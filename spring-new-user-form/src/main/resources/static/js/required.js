const end = document.getElementById('end');
const agree = document.getElementById('agreeTeam');
//const next = document.getElementById('next');
//agree.addEventListener('click', () => {
//  next.disabled = !next.disabled;
//});
const observer = new IntersectionObserver(function(changes) {
  if (changes[0].intersectionRatio === 1) {
    observer.disconnect();
    agree.disabled = false;
  }
});
observer.observe(end);