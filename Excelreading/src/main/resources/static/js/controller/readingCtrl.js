function readingCtrl($scope, $state, $stateParams, uploadService) {

	var flag = false;
	$scope.loader=false;
	$scope.status=false;
	
	$scope.fileChanged = function(files) {
		$scope.status=true;
		if (files != null) {
			var file = files[0];
			$scope.filepath = files[0];
		}else{
			alert("Please Select File!!");
		}
	};
	
	$scope.uploadFile = function() {

		if ($scope.filepath == undefined || $scope.filepath == "") {
			$scope.message = "Please Choose File to Uploaded..";
			$scope.loader = false;
		} else {
			$scope.loader = true;
			uploadService.uploadExcelSheet($scope.filepath).then(
					function(response) {

						$scope.loader = false;

					}, function(eror) {
						//$scope.message = JSON.stringify(eror);
						;
					});
		}

	};

}

angular.module('hrm').controller('readingCtrl', readingCtrl);