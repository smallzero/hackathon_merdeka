starterController.controller('ReportKecuranganController', ['$scope', '$rootScope', '$location', '$http', '$ionicPopup', '$timeout', '$cordovaGeolocation',
	function ($scope, $rootScope, $location, $http, $ionicPopup, $timeout, $cordovaGeolocation) {
		$scope.btnKembali = function () {
			$scope.loading = false;
			$scope.message = "";
			$location.path('/home');
		};

		//Lokasi
		$scope.getLokasi = function () {
			$scope.loading = true;
			$http.get('http://localhost:8080/pakopangws/pakopang/lokasiServices/getLokasiByNama/' + $scope.lokasiTxt).
			success(function (data, status, headers, config) {
				$scope.lokasiList = data;
				$scope.loading = false;
			});
		};
		$scope.selectLokasi = function (lokasi) {
			$scope.lokasi = lokasi;
			$scope.lokasiTxt = lokasi.nama;
			$scope.lokasiList = [];
		};

		$scope.lat = 0;
		$scope.long = 0;
		$scope.btnSimpan = function () {
			$scope.loading = true;
			$scope.message = "Sedang proses mencari lokasi GPS";
			$cordovaGeolocation.getCurrentPosition()
				.then(function (position) {
					$scope.lat = position.coords.latitude;
					$scope.long = position.coords.longitude;
					$scope.message = "Sedang proses mencari lokasi GPS Sukses";
					$scope.message = "GPS Lokasi anda saat ini, Lat : " + $scope.lat + ", Long : " + $scope.long;
									
					$scope.postForm = {
						subyek: $scope.subyek,
						deskripsi: $scope.deskripsi,
						lokasi: $scope.lokasiTxt,
						lat: $scope.lat,
						long: $scope.long

					};
					console.log('data post :' + JSON.stringify($scope.postForm));
					
					$http({
						method: 'POST',
						url: $rootScope.backendAddress + '/pakopangws/pakopang/laporKecuranganServices/insertLaporKecurangan',
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
						$scope.message = "Terimakasih, atas partisipasinya. Laporan kecurangan yang anda laporkan akan kami teruskan ke pihak berwajib. Data Berhasil disimpan.";
						$scope.loading = false;
					});
					$scope.loading = false;
				}, function (err) {
					// error
					alert('code: ' + err.code + '\n' +
						'message: ' + err.message + '\n');

					$scope.loading = false;
				});
		};

	}
]);