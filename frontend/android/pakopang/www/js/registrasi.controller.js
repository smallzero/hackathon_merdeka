starterController.controller('RegistrasiController', ['$scope', '$rootScope', '$location', '$http', '$ionicPopup', '$timeout', '$cordovaGeolocation',
	function ($scope, $rootScope, $location, $http, $ionicPopup, $timeout, $cordovaGeolocation) {
		$scope.btnKembali = function () {
			$scope.loading = false;
			$scope.message = "";
			$location.path('/login');
		};

		$scope.btnRegistrasi = function () {
			if ($scope.password01 == $scope.password02) {
				$scope.postForm = {
					username: $scope.username,
					email: $scope.email,
					password: $scope.password01
				};
				console.log('INFO user ' + JSON.stringify($scope.postForm));
				$http({
					method: 'POST',
					url: $rootScope.backendAddress + '/pakopangws/pakopang/user/registrasi',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					transformRequest: function (obj) {
						var str = [];
						for (var p in obj)
							str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
						return str.join("&");
					},
					data: $scope.postForm
				}).
				success(function (data, status, headers, config) {
					$scope.message = "Terimakasih, atas partisipasinya. Data Berhasil disimpan.";
					$scope.loading = false;
				});

			} else {
				alert('Password tidak sama');
			}
		};
	}
]);