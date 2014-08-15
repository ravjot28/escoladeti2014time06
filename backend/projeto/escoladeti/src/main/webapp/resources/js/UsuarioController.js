function UsuarioController($scope, $http, $routeParams) {
    console.log('Usuario Controller');
    $scope.nome;
    $scope.login;
    $scope.senha;
    $scope.email;
    $scope.ativo;

    $scope.perfisAcesso = [];
    $scope.meuPerfilDeAcesso = {};

    $scope.perfilDeAcessoUsuario = {};

    var tamanho = 0;
    var temMaiuscula = 0;
    var temMinuscula = 0;
    var temNumero = 0;
    var temSimbolo = 0;
    var resultado = 0;

    $scope.novo = function() {
        $scope.getPerfisDeAcesso();
        if ($routeParams.usuarioId) {
            $scope.carregarUsuario();
        } else {
            $scope.usuario = getNovoUsuario();
            console.log(angular.toJson($scope.usuario, true));
            window.location = '#/cadastrousuario';
        }
    };
    $scope.editar = function(usuario) {
        console.log('Editar usuario');
        window.location = '#/cadastrousuario/' + usuario.id;
    };
    $scope.getTodos = function() {
        $http.get("./rest/usuarioSource/usuario")
                .success(function(usuarios, status) {
            $scope.usuarios = usuarios;
        })
                .error(function(data, status) {
            console.log('erro ao buscar usuarios');
        });
    };
    $scope.salvar = function() {
        console.log(angular.toJson($scope.usuario, true));
        $scope.usuario.ativo = true;
        if ($scope.usuario.nome === undefined)
            return toastr.warning('Preencha o campo nome');
        if ($scope.usuario.login === undefined)
            return toastr.warning('Preencha o campo login');
        if ($scope.usuario.senha === undefined)
            return toastr.warning('Preencha o campo senha');
        if ($scope.usuario.email === undefined) {
            return toastr.warning('Preencha o campo email');
        }

        if (!$scope.usuario.senha === $scope.confirmaSenha) {
            toastr.warning('As senhas tem que ser iguais');
            console.log('senha ' + $scope.usuario.senha + ' confirmarSenha ' + $scope.confirmaSenha);
        } else {
            $http.post("./rest/usuarioSource/usuario", $scope.usuario)
                    .success(function(usuario, status) {
                $scope.salvarPerfilDeAcesso();

                toastr.success("Usuario cadastrado com sucesso!");
                setTimeout(function() {
                    window.location = "#/listausuario";
                }, 5000);
                console.log("usuario salvo = " + usuario);
            })
                    .error(function(data, status) {
                console.log("erro ao salvar usuario", data);
                toastr.warning("Erro ao salvar usuario!");
            });
        }
    };
    $scope.deletar = function(usuario) {
        $http({
            method: 'DELETE',
            data: usuario,
            url: './rest/usuarioSource/usuario',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data) {
            console.log("usuario deletado");
            toastr.success("Usuario apagado com sucesso!");
            $scope.getTodos();
        }).error(function(data) {
            console.log("erro ao deletar usuario ");
            toastr.warning("Erro ao apagar usuario!");
        });
    };
    $scope.carregarUsuario = function() {
        if ($routeParams.usuarioId) {
            $http.get('./rest/usuarioSource/usuario/' + $routeParams.usuarioId)
                    .success(function(usuario) {
                $scope.usuario = usuario;
            });
        }
    };

    $scope.getPerfisDeAcesso = function() {
        $http.get("./rest/perfilAcessoSource/perfilAcesso")
                .success(function(perfils, status) {
            $scope.perfisAcesso = perfils;
            console.log(angular.toJson($scope.perfisAcesso, true));
        }).error(function(data, status) {
            console.log('Erro ao carregar perfils ! ' + data);
        });
    };

    $scope.salvarPerfilDeAcesso = function() {
        //fazer refatoração do front e do backend
        //fazer as alterações para padronizar os arquivos de acordo com o novo tipo do projeto
        $scope.perfilDeAcessoUsuario = {
            usuario: $scope.usuario,
            perfilAcesso: $scope.meuPerfilDeAcesso,
            inicioVigencia: $scope.inicioVigencia,
            fimVigencia: $scope.fimVigencia
        };
        
        $http.post("./rest/usuarioPerfilAcessoSource/usuarioPerfilAcesso", $scope.perfilDeAcessoUsuario)
                .success(function(usuarioPerfilDeAcesso, status) {
            console.log('usuario enviado ao back usuario perfil de acesso');
            console.log($scope.perfilDeAcessoUsuario.inicioVigencia + status);
        }).error(function(data, status) {
            console.log($scope.perfilDeAcessoUsuario.fimVigencia + status);
            console.log('Erro ao salvar perfil De acesso ! ' + data);
        });
    };

    $scope.pontuarSenha = function() {
        var senha = $scope.usuario.senha;
        if (senha.length > 0) {
            if (senha.length >= 8 && senha.length <= 10) {
                tamanho = 6 * senha.length;
            } else {
                if (senha.length > 10) {
                    tamanho = 6 * 10;
                } else {
                    tamanho = 0;
                }
            }

            if (senha.charCodeAt(senha.length - 1) > 64 && senha.charCodeAt(senha.length - 1) < 91) {
                temMaiuscula = 20;
            }

            if (senha.charCodeAt(senha.length - 1) > 96 && senha.charCodeAt(senha.length - 1) < 123) {
                temMinuscula = 10;
            }

            if (senha.charCodeAt(senha.length - 1) > 47 && senha.charCodeAt(senha.length - 1) < 58) {
                temNumero = 15;
            }

            if (senha.charCodeAt(senha.length - 1) > 31 && senha.charCodeAt(senha.length - 1) < 48) {
                temSimbolo = 30;
            }

            if (senha.charCodeAt(senha.length - 1) > 57 && senha.charCodeAt(senha.length - 1) < 65) {
                temSimbolo = 30;
            }

            if ((senha.charCodeAt(senha.length - 1) > 91 && senha.charCodeAt(senha.length - 1) < 97) || senha.charCodeAt(senha.length - 1) > 122) {
                temSimbolo = 30;
            }

            resultado = tamanho + temMaiuscula + temMinuscula + temNumero + temSimbolo;
        } else {
            resultado = 0;
        }

        if (resultado < 40) {
            $scope.myStyle = {'background-color': '#ff0000'};
        } else {
            if (resultado >= 40 && resultado < 80) {
                $scope.myStyle = {'background-color': '#ffff00'};
            } else {
                if (resultado >= 80) {
                    $scope.myStyle = {'background-color': '#66ff00'};
                }
            }
        }
    };
    function getNovoUsuario() {
        console.log('novo usuario');
        return {};
    }
    ;
}

function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}
