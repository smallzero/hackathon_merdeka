starterController.controller('DashboardTableController', ['$scope', '$rootScope', '$location', '$http', '$ionicPopup', '$timeout',
	function ($scope, $rootScope, $location, $http, $ionicPopup, $timeout) {
		$scope.dateToday = new Date();
		$scope.loading = true;
		$http.get($rootScope.backendAddress + '/pakopangws/pakopang/hargaPemerintahServices/getHargaPemerintahList').
		success(function (data, status, headers, config) {
			$scope.hargaPemerintahList = data;
			$scope.loading = false;
		});
		
		$scope.loading = true;
		$http.get($rootScope.backendAddress + '/pakopangws/pakopang/hargaMasyarakatServices/getKomoditasByCentraProduksi').
		success(function (data, status, headers, config) {
			$scope.hargaCentraProduksiList = data;
			$scope.loading = false;
		});
		
		$scope.loading = true;
		$http.get($rootScope.backendAddress + '/pakopangws/pakopang/hargaMasyarakatServices/getKomoditasByCentraPasar').
		success(function (data, status, headers, config) {
			$scope.hargaCentraPasarList = data;
			$scope.loading = false;
		});
		
		$scope.btnKembali = function () {
			$scope.loading = false;
			$scope.message = "";
			$location.path('/home');
		};

	}
]);