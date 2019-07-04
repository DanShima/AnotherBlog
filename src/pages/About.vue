<template>
  <Layout>
    <h1>About me</h1>
    <p>Android developer with a background in education and literature.
      Born in China, grew to full-size in The Netherlands, and now based in Stockholm, Sweden.
      Obsessed with food, art, programming, otaku culture, and game(development).</p>
    <h2>Tech skills and languages</h2>
      <ul>
        <li>Build android applications with Java and Kotlin</li>
        <li>Build frontend web applications with Angular.js and Vue.js</li>
        <li>Build simple games with Unity and LibGDX</li>
        <li>Experience with: Java, Kotlin, C#, C++, Python, JS/HTML/CSS</li>
      </ul>
    <h2>Games</h2>
    <ul>
      <li><a href="https://danshima.com/" target="_blank" rel="noopener">HookaGnome</a></li>
      <li><a href="https://github.com/DanShima/GameProject" target="_blank" rel="noopener">Gear Up</a></li>
    </ul>
      <Card/>

  </Layout>
</template>

<script>
import Card from '~/components/Card.vue'
export default {
  components: {
    Card
  },
  metaInfo: {
    title: 'About me'
  }
}
</script>
