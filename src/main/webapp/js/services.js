'use strict';

/* Services */

var services = angular.module('RESTfulExample.services', ['ngResource']);

services.factory('UserFactory', function ($resource) {
    return $resource('/RESTfulExample/rest/getNewsList', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});
