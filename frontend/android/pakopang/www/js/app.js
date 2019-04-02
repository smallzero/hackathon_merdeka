var starter = angular.module('starter', ['ionic', 'starterControllers','ngCordova',  'ionic-datepicker']);

starter.run(function ($ionicPlatform) {
	$ionicPlatform.ready(function () {
		if (window.cordova && window.cordova.plugins.Keyboard) {
			cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
		}
		if (window.StatusBar) {
			StatusBar.styleDefault();
		}
	});
})

starter.filter('currencyIDR', function () {
	var result = function (input) {
		var strInput = '' + input;
		var array01 = strInput.split(".");
		var depanKoma = array01[0];
		if (typeof depanKoma !== 'undefined') {
			var belakangKoma = array01[1];
			var array02 = depanKoma.split('');
			var titik = Math.floor(depanKoma.length / 3);
			if (titik > 0) {
				var result = '';
				if (typeof belakangKoma !== 'undefined') {
					result = ',' + belakangKoma;
				} else {
					result = ',00';
				}
				array02.reverse();
				for (var i = 0; i < array02.length; i++) {
					if ((i * 10) % 3 == 2 && i != (array02.length - 1)) {
						result = '.' + array02[i] + result;
					} else {
						result = array02[i] + result;
					}
				}
				return result;
			} else {
				return ('' + input).replace(',', '.');
			}
		}
	};

	if (typeof result == 'undefined') {
		return '0';
	} else {
		return result;
	}
});

starter.config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
		$stateProvider.
		state('login', {
			url: '/login',
			templateUrl: 'views/login.html',
			controller: 'LoginController'
		})
		.state('home', {
			url: '/home',
			templateUrl: 'views/home.html',
			controller: 'HomeController'
		})
		.state('reportharga', {
			url: '/reportharga',
			templateUrl: 'views/reportingharga.html',
			controller: 'ReportHargaController'
		})
		.state('reportkecurangan', {
			url: '/reportkecurangan',
			templateUrl: 'views/reportingkecurangan.html',
			controller: 'ReportKecuranganController'
		})
		.state('registrasi', {
			url: '/registrasi',
			templateUrl: 'views/registrasi.html',
			controller: 'RegistrasiController'
		})
		.state('dashboardtable', {
			url: '/dashboardtable',
			templateUrl: 'views/dashboardtable.html',
			controller: 'DashboardTableController'
		});
		$urlRouterProvider.otherwise('/login');
}]);

var starterController = angular.module('starterControllers', []);