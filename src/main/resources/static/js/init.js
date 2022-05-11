(function($){
  $(function(){

    $('.sidenav').sidenav();

  }); // end of document ready



})(jQuery); // end of jQuery name space


function logout(){
  document.forms['logoutForm'].submit();
  window.location.href = '/';
}