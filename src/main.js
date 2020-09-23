// This is the main.js file. Import global CSS and scripts here.
// The Client API can be used here. Learn more: gridsome.org/docs/client-api
import '~/style/index.scss';
import DefaultLayout from '~/layouts/Default.vue';
import VueAnalytics from 'vue-analytics';

export default function (Vue, { router, head, isClient }) {
  Vue.use(VueAnalytics, {
    id: 'UA-145072436-1',
    autoTracking: {
      screenview: true,
      pageviewOnLoad: false,
      skipSamePath: true
    },
    debug: {
      sendHitTask: process.env.NODE_ENV === 'production'
    },
    router
  }),
  //import google Font "Stylish"
  head.link.push({
    rel: 'stylesheet',
    href: 'https://fonts.googleapis.com/css?family=Stylish&display=swap'
}),
router.beforeEach((to, _from, next) => {
  head.meta.push({
    key: 'og:url',
    name: 'og:url',
    content: process.env.GRIDSOME_BASE_PATH + to.path,
  })
  next()
}),
  // Set default layout as a global component
  Vue.component('Layout', DefaultLayout);
}
