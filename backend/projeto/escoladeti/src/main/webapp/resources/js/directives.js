var diretivas = angular.module('directives');

diretivas.directive('tsRequired', function () {
    return {
        link: function (scope, element, attrs) {
            console.log('diretiva', scope.solicitacaoForm);
            console.log('addclass', element.addClass);
        }
    }
});

diretivas.directive('mascararTelefone', function () {
    return {
        restrict: 'A',
        replace: true,
        template : "<td>{{telefone.numero.substring(0,4) +'-'+ telefone.numero.substring(4,telefone.numero.length)}}</td>"
    };
});

diretivas.directive('mascararPessoacpfcnpj', function () {
    return {
        restrict: 'A',
        replace: true,
        template : "<td>{{ pessoa.tipo === 'F' ? \n\
            pessoa.cpfCnpj.substring(0,3) +'.'+ pessoa.cpfCnpj.substring(3,6) +'.'+ pessoa.cpfCnpj.substring(6,9) +'-'+ pessoa.cpfCnpj.substring(9,pessoa.cpfCnpj.length) : \n\
            pessoa.cpfCnpj.substring(0,2) +'.'+ pessoa.cpfCnpj.substring(2,5) +'.'+ pessoa.cpfCnpj.substring(5,8) +'/'+ pessoa.cpfCnpj.substring(8,12) +'-'+ pessoa.cpfCnpj.substring(12,pessoa.cpfCnpj.length) \n\
            }}</td>"
    };
});


diretivas.directive('myFocus', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            scope.$watch(attr.myFocus, function (n, o) {
                if (n !== 0 && n) {
                    element[0].focus();
                }
            });
        }
    };
});
app.directive('myBlur', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            element.bind('blur', function () {
                scope.$apply(attr.myBlur);
                scope.$eval(attr.myFocus + '=false');
            });
        }
    };
});