<template>
  <div class="post-card content-box" :class="{'post-card--has-poster' : post.poster}">

    <div class="post-card__header">
      <g-image alt="Cover image" v-if="post.coverImage" class="post-card__image" :src="post.coverImage" />
    </div>

    <div class="post-card__content">
      <h2 class="post-card__title" v-html="post.title" />
      <p class="post-card__description" v-html="post.description" />

      <PostMeta class="post-card__meta" :post="post" />
      <PostTags class="post-card__tags" :post="post" />

    <!--read more button-->
    <g-link class="post-card__link" :to="post.path" >
      <i class="arrow">
      <font-awesome :icon="['fa', 'chevron-right']" size="xs"/>
      <font-awesome :icon="['fa', 'chevron-right']" size="xs"/>
      <font-awesome :icon="['fa', 'chevron-right']" size="xs"/>
      </i>
    </g-link>
    </div>
  </div>
</template>

<style lang="scss">
i {
    position: absolute;
    bottom: 0px;
    right: 0%;
    left: 85%;
    padding-bottom: 10%;
    color: #86A3C3;
		animation: arrow-animation 2s;
		animation-iteration-count: infinite;
	}
i:first-child{
		animation-delay: 0.2s;
		margin-left: 5px;
		opacity: 0.15;
	}
i + i {
		animation-delay: 0.4s;
		opacity: 0.5;
	}
i + i + i {
		animation-delay: 0.6s;
		opacity: 1;
	}

i:hover {
    color: rgb(73, 80, 175);
}

@keyframes arrow-animation {
  0%   { opacity: 0.1; }
  50%  { opacity: 0.5; }
  100% { opacity: 1; }
}

.post-card {
  margin-bottom: var(--space);
  position: relative;
  &__header {
    margin-left: calc(var(--space) * -1);
    margin-right: calc(var(--space) * -1);
    margin-bottom: calc(var(--space) / 2);
    margin-top: calc(var(--space) * -1);
    overflow: hidden;
    border-radius: var(--radius) var(--radius) 0 0;
    &:empty {
      display: none;
    }
  }
  &__image {
    min-width: 100%;
  }
  &__title {
    margin-top: 0;
  }
  &:hover {
    transform: translateY(-5px);
    box-shadow: 1px 10px 30px 0 rgba(0,0,0,.1);
  }
  &__tags {
    z-index: 1;
    position: relative;
    margin-bottom: 5px;
  }
  &__link {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    opacity: 0.0;
    overflow: hidden;
    // hides the arrows: text-indent: -9999px;
    z-index: 0;
  }
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
  props: ["post"],
};
</script>