<template>
  <div class="layout">
    <header class="header">
      <div class="siteTitle"><strong>
        <g-link to="/">{{ $static.metaData.siteName }}</g-link>
      </strong>
      </div>
      <nav class="nav">
        <g-link class="nav__link" to="/">Home</g-link>
        <g-link class="nav__link" to="/about">About</g-link>
        <g-link class="nav__link" to="/blog">Blog</g-link>
      </nav>
    </header>
    <slot/> <!-- Page content will be inserted here -->
    <div v-if="sidebar">
    //do nothing
    </div>
  </div>
</template>

<static-query>
query {
  metaData {
    siteName
  }
}
</static-query>

<style>
body {
  font-family: -apple-system, system-ui, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
  margin:0;
  padding:0;
  line-height: 1.5;
}

.layout {
  max-width: 760px;
  margin: 0 auto;
  padding-left: 20px;
  padding-right: 20px;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  height: 100px;
  font-size: 1.5em;
  font-family: "Stylish";
  font-size: 28px;
}

.header a {
  text-decoration: none;
  color:#7268A6;
}

.siteTitle {
  text-transform: uppercase;
}

.nav__link {
  font-size: 20px;
  margin-left: 20px;
}
</style>

<script>
export default {
  props: ['sidebar']
}

</script>
