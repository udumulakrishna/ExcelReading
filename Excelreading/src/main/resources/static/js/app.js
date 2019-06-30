var hrm = angular.module('hrm', [ 'ui.router',
		'ngStorage' ]);
hrm.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/uploadExcel');
	$stateProvider.state('uploadExcel', {
		url : '/uploadExcel',
		templateUrl : 'views/uploadExcel.html',
		controller : 'readingCtrl'
	})
});