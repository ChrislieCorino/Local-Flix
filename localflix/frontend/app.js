const API='http://localhost:8080/api';
let movies=[],categories=[],watchlist=new Set(),active='All';
const $=id=>document.getElementById(id);

async function api(path,options){
    const r=await fetch(API+path,options);
    if(!r.ok)throw new Error('API error');return r.json()
    }

async function init(){
    try{[movies,categories,watchlist]=await Promise.all([api('/movies'),api('/categories'),api('/watchlist')]);
        watchlist=new Set(watchlist);
        renderFilters();
        render();
        renderWatchlist();
    }
    catch(e){
        console.error(e);
        $('grid').innerHTML='<div class="empty">Backend not running. Start the Java Spring Boot project on port 8080.</div>';
    }}

function renderFilters(){
    const f=$('filters');
    f.innerHTML=categories.map(c=>`<button class="filter ${c===active?'active':''}" onclick="setCategory('${c.replaceAll("'","\\'")}')">${c}</button>`).join('')
}

function filtered(){
    const q=$('searchInput').value.toLowerCase().trim();
    return movies.filter(m=>(active==='All'||m.category===active||m.genre===active)&&(!q||(m.title+' '+m.description+' '+m.genre).toLowerCase().includes(q)))
}

function card(m){
    return `<article class="card"><img class="poster" src="${m.poster}" alt="${m.title}"><button class="preview" onclick="event.stopPropagation();
    openTrailer(${m.id})">▶</button><div class="card-overlay" onclick="openTrailer(${m.id})"><div class="card-title">${m.title}</div><div class="card-meta">${m.year} • ${m.rating} • ${m.duration}</div><p class="card-desc">${m.description}</p><button class="list-btn" onclick="event.stopPropagation();
    toggleList(${m.id})">${watchlist.has(m.id)?'✓ In My List':'＋ My List'}</button></div></article>`
}

function render(){
    const list=filtered();
    $('grid').innerHTML=list.map(card).join('');
    $('empty').classList.toggle('hidden',list.length>0)
}

function renderWatchlist(){
    const list=movies.filter(m=>watchlist.has(m.id));
    $('watchGrid').innerHTML=list.map(card).join('');
    $('watchEmpty').classList.toggle('hidden',list.length>0)
}

function setCategory(c){
    active=c;
    renderFilters();
    render()
}

async function toggleList(id){
    try{const r=await api('/watchlist/'+id,{method:'POST'});
    if(r.inWatchlist)watchlist.add(id);else watchlist.delete(id);
    render();
    renderWatchlist()}catch(e){alert('Could not update watchlist. Is the backend running?')}
}

function openTrailer(id){
    const m=movies.find(x=>x.id===id);
    if(!m)return;
    $('modalTitle').textContent=m.title;
    $('modalDescription').textContent=m.description;
    $('modalCategory').textContent=m.category.toUpperCase()+' • '+m.genre.toUpperCase();
    $('modalMeta').innerHTML=`<span>${m.year}</span><span>${m.rating}</span><span>${m.duration}</span>`;
    $('trailer').src=m.trailer+'?autoplay=1';
    $('modal').classList.remove('hidden')
}

function closeModal(){
    $('modal').classList.add('hidden');
    $('trailer').src=''
}

$('searchInput').addEventListener('input',render);
$('clearSearch').onclick=()=>{$('searchInput').value='';
    render()};
    $('closeModal').onclick=closeModal;
    $('modal').onclick=e=>{if(e.target===$('modal'))closeModal()};
    $('heroPlay').onclick=()=>openTrailer(1);$('heroList').onclick=()=>toggleList(1);
    document.addEventListener('keydown',e=>{if(e.key==='Escape')closeModal()});
    init();
