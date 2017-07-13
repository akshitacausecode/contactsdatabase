grails.serverURL = 'http://localhost:8080'

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'UserRole'
grails.plugin.springsecurity.authority.className = 'Role'


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
		[pattern: '/assets/**',      filters: 'none'],
		[pattern: '/**/js/**',       filters: 'none'],
		[pattern: '/**/css/**',      filters: 'none'],
		[pattern: '/**/images/**',   filters: 'none'],
		[pattern: '/**/favicon.ico', filters: 'none'],
		[pattern: '/**',             filters: 'JOINED_FILTERS']
]
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.successHandler.defaultTargetUrl = "/"
grails.plugin.springsecurity.logout.afterLogoutUrl = "/"

environments {
	production {
		grails.config.locations = [
				"classpath:com/causecode/config/DefaultAsyncMailConfig.groovy",
				"classpath:com/causecode/core/DefaultSpringSecurityCoreConfig.groovy",
				"classpath:com/causecode/rest/DefaultSpringSecurityRestConfig.groovy",
				"classpath:application.groovy",
				"file:///root/localconfig/application-local.groovy"
		]
	}
	development {
		grails.config.locations = [
				"classpath:com/causecode/config/DefaultAsyncMailConfig.groovy",
				"classpath:com/causecode/core/DefaultSpringSecurityCoreConfig.groovy",
				"classpath:com/causecode/rest/DefaultSpringSecurityRestConfig.groovy",
				"classpath:application.groovy",
				"classpath:application-local.groovy"
		]
	}
	staging {
		grails.config.locations = [
				"classpath:com/causecode/config/DefaultAsyncMailConfig.groovy",
				"classpath:com/causecode/core/DefaultSpringSecurityCoreConfig.groovy",
				"classpath:com/causecode/rest/DefaultSpringSecurityRestConfig.groovy",
				"classpath:application.groovy",
				"file:///root/localconfig/application-local.groovy"
		]
	}
}