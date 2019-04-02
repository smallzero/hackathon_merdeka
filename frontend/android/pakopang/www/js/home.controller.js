starterController.controller('HomeController', ['$scope', '$rootScope', '$location', '$http', '$ionicPopup', '$timeout',
	function ($scope, $rootScope, $location, $http, $ionicPopup, $timeout) {
		$scope.dateToday = new Date();
		
		$scope.goReportHarga =  function() {
			$location.path('/reportharga');	
		};
		
		$scope.doSignOut = function(){
			$location.path('/login');	
		};
		
		$scope.goLaporKecurangan = function(){
			$location.path('/reportkecurangan');	
		}
		
		$scope.btnDetilReport = function(){
			$location.path('/dashboardtable');	
		}
		
	}
]);