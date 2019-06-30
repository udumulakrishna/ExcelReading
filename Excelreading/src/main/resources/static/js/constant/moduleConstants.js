function ModuleConstants() {
	var protocol = "http";
	var host = "localhost";
	var port = 9000;
	var url = protocol + "://" + host + ":" + port + "/";

	return {
		PROTOCOL : protocol,
		HOST : host,
		PORT : port,
		URL : url,

		UPLOAD_EXCELSHEET : function() {
			return url + "upload/organizationData";
		}
	}
};
hrm.constant('MODULE_CONFIG', ModuleConstants());