'use strict';
var appCabecalho = angular.module('cabecalho', ['ngRoute']);

appCabecalho.config(['$routeProvider',
	function ($routeProvider) {
		
		$routeProvider
		.when('/pessoafisica',{
			templateUrl : 'partials/FormPF.html',
			controller : 'PessoaFisicaController'
		})
		.when('/pessoajuridica',{
			templateUrl : 'partials/FormPJ.html',
			controller : 'PessoaJuridicaController'
		})
		.when('/cadastrousuario',{
			templateUrl : 'partials/CadastroUsuario.html',
			controller : 'CadastroUsuarioController'
		})
		.when('/cadastroperfilusuario',{
			templateUrl : 'partials/CadastroPerfilUsuario.html',
			controller : 'perfilUsuarioController'
		})
		.when('/cadastrotela',{
			templateUrl : 'partials/CadastroTela.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastropais',{
			templateUrl : 'partials/CadastroPais.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastroestado',{
			templateUrl : 'partials/CadastroEstado.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrocidade',{
			templateUrl : 'partials/CadastroCidade.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrodistrito',{
			templateUrl : 'partials/CadastroDistrito.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrobairro',{
			templateUrl : 'partials/CadastroBairro.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrocep',{
			templateUrl : 'partials/CadastroCep.html',
			// controller : 'nomeDoController'
		})
		.when('/listadistrito',{
			templateUrl : 'partials/ListaDistrito.html',
			// controller : 'nomeDoController'
		})
		.when('/listapais',{
			templateUrl : 'partials/ListaPais.html',
			// controller : 'nomeDoController'
		})
		.when('/listaestado',{
			templateUrl : 'partials/ListaEstado.html',
			// controller : 'nomeDoController'
		})
		.when('/listapessoafisica',{
			templateUrl : 'partials/ListaPF.html',
			// controller : 'nomeDoController'
		})
		.when('/listapessoajuridica',{
			templateUrl : 'partials/ListaPJ.html',
			// controller : 'nomeDoController'
		})
		.when('/listacidade',{
			templateUrl : 'partials/ListaCidade.html',
			// controller : 'nomeDoController'
		})
		.when('/listabairro',{
			templateUrl : 'partials/ListaBairro.html',
			// controller : 'nomeDoController'
		})
		.when('/listacep',{
			templateUrl : 'partials/ListaCep.html',
			// controller : 'nomeDoController'
		})
		.when('/listausuario',{
			templateUrl : 'partials/ListaUsuario.html',
			// controller : 'nomeDoController'
		})
		.when('/listaperfilusuario',{
			templateUrl : 'partials/ListaPerfilUsuario.html',
			// controller : 'nomeDoController'
		})
		.when('/listatela',{
			templateUrl : 'partials/ListaTela.html',
			// controller : 'nomeDoController'
		})
		.otherwise({redirectTo: '/'
		});
	}
]);


appCabecalho.factory('bd', function(){	
	return { name : 'banco de dados' };
});