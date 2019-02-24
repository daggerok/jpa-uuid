const baseHref = !process.env.BASE_HREF ? '/' : process.env.BASE_HREF;
module.exports = {
  head: [
    ['link', { rel: 'icon', href: '/favicon.ico' }]
  ],
  base: baseHref,
  themeConfig: {
    repo: 'daggerok/jpa-uuid',
    lastUpdated: 'Last Updated', // string | boolean
    '/': {
      sidebar: 'auto'
    },
    sidebarDepth: 2,
    navbar: true,
  }
};
