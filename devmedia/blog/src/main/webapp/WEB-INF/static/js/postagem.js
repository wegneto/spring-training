$(document).ready(function() {

	$(document).on('click', 'button[id*="button_"]',
			function(a) {
				var pageNumber = $(this).val();
				tbody(pageNumber);
			});

	$('#search').keyup(function() {
		var value = $(this).val();

		var exp = new RegExp('^[a-zA-Z0-9]');

		if (exp.test(value)) {
			search(value);
		} else {
			tbody(1);
		}
	});

	$("#save-ajax").submit(function(event) {
		event.preventDefault();
		$.post('/blog/postagem/ajax/save', $(this).serialize())
			.done(function(result) {
				
				if (result.status != 'FAIL' ) {
					$('#info').empty().append("<p>Postagem salva com sucesso</p>"
							+ "<p>Abrir postagem: <a href='/blog/"
							+ result.postagem.permalink
							+ "'>"
							+ result.postagem.titulo
							+ "</a></p>");
					
					$('#save-ajax').each(function() {
						this.reset();
					});
					
					$('#titulo-error').empty();
					$('#texto-error').empty();
					
				} else {
					$('#titulo-error').empty().append(result.tituloError);
					$('#texto-error').empty().append(result.textoError);
				}
				
			})
			.fail(function(error) {
				$('#info').empty().append("<p>Error: " + error.status + ", " + error.statusText + "</p>");
			});

	});

});

function search(value) {
	var url = "/blog/postagem/ajax/titulo/" + value + "/page/1";

	$('#table-ajax').load(url, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error: ";
			$("#info").html(msg + xhr.status + " " + xhr.statusText);
		}
	});
}

function tbody(page) {
	var url = "/blog/postagem/ajax/page/" + page;

	var titulo = $('#search').val();

	if (titulo.length > 0) {
		url = "/blog/postagem/ajax/titulo/" + titulo + "/page/" + page;
	} else {
		url = "/blog/postagem/ajax/page/" + page;
	}

	$("#table-ajax").load(url, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error: ";
			$("#info").html(msg + xhr.status + " " + xhr.statusText);
		}
	});

}