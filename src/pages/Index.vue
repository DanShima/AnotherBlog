<template>
  <Layout :sidebar="true">

    <!-- Learn how to use images here: https://gridsome.org/docs/images -->
    <div class="homeImage">
    <g-image alt="Example image" src="~/profilepic.jpg" width="600" />
    </div>

    <h2>I'm alive</h2>

    <p class="home-links fa-2x">
      <a href="https://www.linkedin.com/in/danningch/" target="_blank" rel="noopener"><font-awesome :icon="['fab', 'linkedin']"/></a>
      <a href="https://github.com/danshima" target="_blank" rel="noopener"><font-awesome :icon="['fab', 'github']"/></a>
    </p>
  </Layout>
</template>

<script>
export default {
  name: 'Index',
  methods: {
    track () {
      this.$ga.page('/')
    }
  },
  metaInfo: {
    title: 'Home page'
  }
}
</script>

<style>
.home-links a {
  margin-right: 1rem;
  color:#7268A6;
}
</style>
