starterController.controller('ReportHargaController', ['$scope', '$rootScope', '$location', '$http', '$ionicPopup', '$timeout', '$cordovaGeolocation',
	function ($scope, $rootScope, $location, $http, $ionicPopup, $timeout, $cordovaGeolocation) {
		$scope.getNamaKomoditas = function () {
			$scope.loading = true;
			$http.get('http://localhost/server/komoditas.php').
			success(function (data, status, headers, config) {
				$scope.namaKomoditasList = data;
				$scope.loading = false;
			});
		};

		$scope.selectKomoditas = function (komoditas) {
			$scope.namaKomoditas = komoditas.nama;
			$scope.namaKomoditasList = [];
		};
		$scope.lat = 0;
		$scope.long = 0;
		$scope.getGPSLocation = function () {
			$scope.loading = true;
			$scope.message = "Sedang proses mencari lokasi GPS";
			$cordovaGeolocation
				.getCurrentPosition()
				.then(function (position) {
					$scope.lat = position.coords.latitude
					$scope.long = position.coords.longitude
				}, function (err) {
					// error
					alert('code: ' + err.code + '\n' +
						'message: ' + err.message + '\n');
				});
			$timeout(function () {
				$scope.message = "Sedang proses mencari lokasi GPS Sukses";
			}, 1000);
			$scope.message = "";
			$scope.loading = false;
		};
		
		$scope.btnSimpan = function(){
			$scope.message = "Lat : "+$scope.lat +', Long : '+$scope.long;
		}

	}
]);