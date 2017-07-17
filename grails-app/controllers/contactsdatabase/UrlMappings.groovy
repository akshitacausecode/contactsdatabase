package com.causecode

import grails.util.Environment

/**
 * This class is used for mapping requests to controller and actions.
 */
@SuppressWarnings(['DuplicateStringLiteral'])
class UrlMappings {

    // URLMapping are used from Nucleus.
    static mappings = {
        if (Environment.current != Environment.PRODUCTION) {
            '/dummy'(controller: 'dummy', action: 'test')
        }

        '/search'(controller: 'search', action: 'index')
        '500'(view: '/error')
        '404'(view: '/notFound')
    }
}