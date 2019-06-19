<template>
  <Layout>

    <!-- Learn how to use images here: https://gridsome.org/docs/images -->
    <g-image alt="Example image" src="~/hackathonshot.png" width="300" />

    <h1>I'm alive</h1>

    <p>

    </p>

    <p class="home-links">
      <a href="https://www.linkedin.com/in/danningch/" target="_blank" rel="noopener">LinkedIn</a>
      <a href="https://github.com/danshima" target="_blank" rel="noopener">GitHub</a>
    </p>

  </Layout>
</template>

<script>
export default {
  metaInfo: {
    title: 'Hello, world!'
  }
}
</script>

<style>
.home-links a {
  margin-right: 1rem;
}
</style>
