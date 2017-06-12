"use strict"

$(function() {

  console.info('script de cursos-search-backoffice.js ready');


  $( "#buscadorCursosBO" ).autocomplete({

      source: function( request, response ) {
        $.ajax( {
          url: "/proyectofinal/api/curso/?filtro=" + $("#buscadorCursosBO").val(),
          dataType: "json",
          success: function( data ) {
        	var aString = [];
            $.each(data, function(index, curso){
            	aString.push({"label":curso.nomCurso, "value":curso.id});
        	});
            response( aString );
          }
        } );
      },
      minLength: 3,
      select: function( event, ui ) {
    	  
        console.info( "Seleccionado: " + ui.item.value + " id/nombre " + ui.item.label );
        var url = "admin/curso/edit/"+ ui.item.value;
        window.location.href = url;

      }

    } );

  

});