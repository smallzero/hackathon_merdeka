starterController.controller('ReportHargaController', ['$scope', '$rootScope', '$location', '$http', '$ionicPopup', '$timeout', '$cordovaGeolocation',
	function ($scope, $rootScope, $location, $http, $ionicPopup, $timeout, $cordovaGeolocation) {
		//Komoditas
		$scope.getNamaKomoditas = function () {
			$scope.loading = true;
			$http.get($rootScope.backendAddress +'/pakopangws/pakopang/komoditasServices/getKomoditasByNama/' + $scope.namaKomoditasTxt).
			success(function (data, status, headers, config) {
				$scope.namaKomoditasList = data;
				$scope.loading = false;
			});
		};
		$scope.selectKomoditas = function (komoditas) {
			$scope.namaKomoditas = komoditas;
			$scope.namaKomoditasTxt = komoditas.nama;
			$scope.namaKomoditasList = [];
		};

		//Satuan
		$scope.getNamaSatuan = function () {
			$scope.loading = true;
			$http.get($rootScope.backendAddress + '/pakopangws/pakopang/satuanServices/getSatuanByNama/' + $scope.namaSatuanTxt).
			success(function (data, status, headers, config) {
				$scope.namaSatuanList = data;
				$scope.loading = false;
			});
		};
		$scope.selectSatuan = function (satuan) {
			$scope.namaSatuan = satuan;
			$scope.namaSatuanTxt = satuan.nama;
			$scope.namaSatuanList = [];
		};

		//Lokasi
		$scope.getNamaLokasi = function () {
			$scope.loading = true;
			$http.get($rootScope.backendAddress + '/pakopangws/pakopang/lokasiServices/getLokasiByNama/' + $scope.namaLokasiTxt).
			success(function (data, status, headers, config) {
				$scope.namaLokasiList = data;
				$scope.loading = false;
			});
		};
		$scope.selectLokasi = function (lokasi) {
			$scope.namaLokasi = lokasi;
			$scope.namaLokasiTxt = lokasi.nama;
			$scope.namaLokasiList = [];
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

					if (typeof $scope.namaKomoditas === 'undefined'){
						$scope.namaKomoditas = {};
						$scope.namaKomoditas.id = 0;
						$scope.namaKomoditas.nama = $scope.namaKomoditasTxt
					}

					if (typeof $scope.namaLokasi === 'undefined'){
						$scope.namaLokasi = {};
						$scope.namaLokasi.id = 0;
						$scope.namaLokasi.nama = $scope.namaLokasiTxt;
					}
					$scope.postForm = {
						jnsPusatKomoditas: $scope.jenisPusatKomoditas,
						komoditasnama: $scope.namaKomoditas.nama,
						komoditasid: $scope.namaKomoditas.id,
						harga: $scope.harga,
						perSatuan: $scope.hargaPersatuan,
						stok: $scope.stok,
						satuan: $scope.namaSatuan.id,
						lokasinama: $scope.namaLokasi.nama,
						lokasiid: $scope.namaLokasi.id,
						lat: $scope.lat,
						long: $scope.long

					};
					console.log('data post :' + JSON.stringify($scope.postForm));
					$http({
						method: 'POST',
						url: $rootScope.backendAddress + '/pakopangws/pakopang/hargaMasyarakatServices/insertHargaMasyarakat',
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
				}, function (err) {
					// error
					alert('code: ' + err.code + '\n' +
						'message: ' + err.message + '\n');

					$scope.loading = false;
				});
		};

		$scope.btnKembali = function () {
			$scope.loading = false;
			$scope.message = "";
			$location.path('/home');
		}


	}
]);