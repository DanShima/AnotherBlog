// This is where project configuration and plugin options are located.
// Learn more: https://gridsome.org/docs/config

// Changes here require a server restart.
// To restart press CTRL + C in terminal and run `gridsome develop`

module.exports = {
  siteName: 'Danshima',
  siteDescription: "A safe space to stalk me",
  icon: "src/images/poring1.jpg",
  transformers: {
    remark: {}
  },
  plugins: [
    {
      use: "@gridsome/source-filesystem",
      options: {
        path: "blog/**/*.md",
        typeName: "Post", // the GraphQL entity that will be created
        route: "/blog/:slug"
      }
    },
    {
      use: '@gridsome/plugin-google-analytics',
      options: {
        id: 'UA-145072436-1'
      }
    }

  ]
}
