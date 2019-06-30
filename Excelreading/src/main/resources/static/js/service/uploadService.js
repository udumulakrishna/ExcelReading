angular.module('hrm').service("uploadService",
		function($http, MODULE_CONFIG) {

			this.uploadExcelSheet = function(xlsfile) {
				var fd = new FormData();
				fd.append('file', xlsfile);
				return $http({
					method : 'POST',
					url : MODULE_CONFIG.UPLOAD_EXCELSHEET(),
					data : fd,
					transformRequest : angular.identity,
					headers : {
						'Content-Type' : undefined
					}
				}).success(function(data, status, headers, config) {
					return data;
				}).error(function(data, status, headers, config) {
					return data;

				});
			};

		});