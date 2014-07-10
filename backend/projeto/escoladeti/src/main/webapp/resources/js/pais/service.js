services = angular.module("services");

function PaisService($http) {	
	console.log('carregando service pais');
	return {
		
		deletar: function (pais) {
			 return $http({
                 method: 'DELETE',
                 data: pais,
                 url: './rest/paisSource/pais',
                 headers: {'Content-Type': 'application/json; charset=UTF-8'}
             });
		},
		
		buscarPorNome: function (filtro) {
			return $http.get('./rest/paisSource/pais?q=' + filtro.toUpperCase());
		},
		
		buscar: function (paisId) {
			return $http.get('./rest/paisSource/pais/' +  paisId);
		},
		
		salvar: function (pais) {
			return $http.post('./rest/paisSource/pais', {
				nome: pais.nome.toUpperCase(),
				id: pais.id,
				codigo: pais.codigo,
				sigla: pais.sigla.toUpperCase()
			});
		},
	
		listar: function (nrPagina) {
			return $http.get('./rest/paisSource/listar/pag/' + nrPagina);
		},
		buscarTodos: function () {
			return $http.get('./rest/paisSource/listar');
		}
	};
}

services.factory('paisService', ['$http', PaisService]);
