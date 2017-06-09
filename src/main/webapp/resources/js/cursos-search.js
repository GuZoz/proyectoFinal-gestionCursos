"use strict"

$(function() {

  console.debug('script de cursos-search.js ready');


  $( "#buscadorCursos" ).autocomplete({

      source: function( request, response ) {
        $.ajax( {
          url: "/proyectofinal/api/curso/?filtro=" + $("#buscadorCursos").val(),
          dataType: "json",
          success: function( data ) {
        	var aString = [];
            $.each(data, function(index, curso){
            	aString.push({"label":curso.nombre, "value":curso.id});
        	});
            response( aString );
          }
        } );
      },
      minLength: 3,
      select: function( event, ui ) {
    	  
        console.debug( "Seleccionado: " + ui.item.value + " id/nombre " + ui.item.label );
        var url = "detail/"+ ui.item.value;
        window.location.href = url;

      }

    } );

  

});