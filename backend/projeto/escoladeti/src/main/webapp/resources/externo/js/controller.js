var controllers = angular.module('controllers');

function ExternoController($scope, $http, $routeParams) {
    console.log('carregando controller externo');
    
    $scope.participante = {};
    
    $scope.ativaBotao = function (pagina) {
        if(!pagina){
            $scope.ativa = '';
        }else{
            $scope.ativa = pagina;   
        }
    },
    $scope.getMateriaisProduzidos = function (pageNumber){
        $http({
            method: 'GET',
            url: './public/rest/materiaisproduzidos/pag/' + pageNumber
        }).success(function (materiaisProduzidos) {
            $scope.materiaisProduzidos = materiaisProduzidos;
        });
    },
    $scope.buscaMateriaisContendoNome = function (){
        console.log('busca materiais: '+ $scope.busca);
        if (!$scope.busca.empty){
        $http({
                method: 'GET',
                url: './public/rest/buscamateriaisproduzidos?q=' + $scope.busca.toUpperCase()
            }).success(function (materiaisProduzidos) {
                console.log('busca materiaisProduzidos', materiaisProduzidos);
                $scope.materiaisProduzidos = materiaisProduzidos;
            });
        }else{
           $scope.getMateriaisProduzidos(); 
        }    
    },
    $scope.getEventos = function (pageNumber){
        console.log('getEventos pag: ', pageNumber);

        $http({
            method: 'GET',
            url: './public/rest/proximoseventos'
        }).success(function (proximosEventos) {
            console.log('Proximos Eventos: ', proximosEventos);
            $scope.proximosEventos = proximosEventos;
        });
        $http({
            method: 'GET',
            url: './public/rest/ultimoseventos'
        }).success(function (ultimosEventos) {
            console.log('Ultimos Eventos: ', ultimosEventos);
            $scope.ultimosEventos = ultimosEventos;
        });
    },
    $scope.detalhesEvento = function (eventoId){
        console.log('Detalhes Evento id :', eventoId);
        window.location = '#/detalhes-evento/' + eventoId;
    },
    $scope.carregaEvento = function (){
        console.log('Carrega Evento id :', $routeParams.eventoId);
        if($routeParams.eventoId){
        $http({
                method: 'GET',
                url: './public/rest/evento/' + $routeParams.eventoId
            }).success(function (evento) {
                console.log('Detalhes Evento: ', evento);
                $scope.evento = evento;               
            });
        }else{
            window.location = '#/eventos';
        }    
    };
    $scope.salvarParticipante = function(eventoId) {
        console.log('Salvar Participante : eventoId: ' + eventoId);

        $scope.participante.idevento = eventoId;
        $scope.participante.pagamento = "PENDENTE";
        
        if($scope.participante.deficiente === 'N' || $scope.participante.deficiente === undefined){
            $scope.participante.deficiente = 'N';
            $scope.participante.necessidade = 'N/P';
        }
                           
        console.log('$scope.participante salvo: ', $scope.participante);
        
        $http.post('./public/rest/salvarparticipante/', $scope.participante)
        .success(function(participante) {
            console.log('Participante Salvo: ' + participante);
            $scope.participante = {};
            $scope.message = "Participante "+ participante.nome +" Cadastrado para o Evento";
        }).error(function(data) {
            console.log('Erro ao salvar Participante: ' + data.messageDeveloper );
            $scope.message = data.message;
        });
    };
};

controllers.controller('ExternoController', ['$scope', '$http', '$routeParams', ExternoController ]);