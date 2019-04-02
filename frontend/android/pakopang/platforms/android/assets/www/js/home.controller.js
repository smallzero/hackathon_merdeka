starterController.controller('HomeController', ['$scope', '$rootScope', '$location', '$http', '$ionicPopup', '$timeout',
	function ($scope, $rootScope, $location, $http, $ionicPopup, $timeout) {
		$scope.dateToday = new Date();
		
		$scope.goReportHarga =  function() {
			$location.path('/reportharga');	
		}
	}
]);