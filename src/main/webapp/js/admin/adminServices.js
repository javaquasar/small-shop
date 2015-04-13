define([
    'angular',
    'angularResource',
    'angularFileUpload'
], function (ng, angularResource) {
    var services = ng.module('adminServices', ['ngResource']);

    services.factory('SolrAdmin', ['$resource', '$upload',
        function ($resource, $upload) {

            var root = '/site/solr';

            var SolrAdmin = $resource(root, {}, {
                reindex: {
                    url: root + '/reindex',
                    method: 'POST'
                }
            });

            return SolrAdmin;
        }]);



    return services;
});