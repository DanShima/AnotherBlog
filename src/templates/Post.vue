<template>
  <Layout>
    <br>
    <g-link to="/blog" class="link">  &larr; Go Back</g-link>

    <div class="post-title">
      <h1>{{$page.post.title}}</h1>
      <PostMeta :post="$page.post" />
    </div>

    <div class="post-content">
       <div class="post__header">
        <g-image alt="Cover image" v-if="$page.post.coverImage" :src="$page.post.coverImage" />
      </div>
      <p v-html="$page.post.content" />
    </div>

  </Layout>
</template>

<page-query>
query Post ($path: String!) {
  post: post (path: $path) {
    id
    title
    content
    date (format: "D MMMM YYYY")
    timeToRead
    tags {
      id
      title
      path
    }
    description

  }
}
</page-query>

<style>
.post-title {
  text-align: center;
  font-size: 20px;
  padding: 2em 0;
  font-family: 'Stylish';
}
.post-content {
  font-size: 18px;
}
</style>

<script>
import PostMeta from '~/components/PostMeta'
import PostTags from '~/components/PostTags'
export default {
   components: {
    PostMeta,
    PostTags
  },
  metaInfo() {
    return {
      title: this.$page.post.title,
      meta: [
        {
          name: 'og:description',
          name: 'og:description',
          content: this.$page.post.description,
        },
        {
          key: 'twitter:description',
          name: 'twitter:description',
          content: this.$page.post.description,
        },
      ],
    };
  }
};
</script>