starterController.controller('LoginController', ['$scope', '$rootScope', '$location', '$http', '$ionicPopup', '$timeout',
	function ($scope, $rootScope, $location, $http, $ionicPopup, $timeout) {

		//$rootScope.backendAddress = 'http://112.78.142.74:52002'
		$rootScope.backendAddress = 'http://localhost:8080';
		$rootScope.userLogin = [];
		$scope.loading = false;

		$scope.doAppExit = function () {
			navigator.app.exitApp();
		};		
		
		$scope.btnRegistrasi = function(){
			$location.path('/registrasi');	
		};
		
		$scope.doLogin = function () {	
			var loginForm = $scope.user;
						
			if( typeof loginForm === 'undefined' ) {
				var alertPopup = $ionicPopup.alert({
					 title: 'Login Gagal',
					 template: 'User dan password yang anda masukan salah!'
				});	
			} else {						
				//$scope.loading = true;	
				//$location.path('/home');
				//$scope.loading = false;
				
				$http({
					method: 'POST',
					url: $rootScope.backendAddress + '/pakopangws/pakopang/user/getAuthentification',
					headers: { 'Content-Type': 'application/x-www-form-urlencoded'},
					transformRequest: function(obj) {
					var str = [];
					for (var p in obj)
						str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
						return str.join("&");
					},
					data: loginForm
				}).success(function(data, status, headers, config) {
					$scope.loading = false;
					//console.log('INFO data.length = '+data.length);
					if(data.length==0) {
						var alertPopup = $ionicPopup.alert({
							 title: 'Sign In Failed',
							 template: 'Wrong username or password, please check your username and password correctly!'
						});	
					} else {
						$rootScope.userLogin = data;	
						$location.path('/home');
					}
				}).error(function(data, status, headers, config) {
					var alertPopup = $ionicPopup.alert({
							 title: 'Login gagal ',
							 template: 'Check your Network Connection!'
						});	
					$scope.loading = false;
				});	
			} 
		};
}]);