package cn.sliew.milky.cache.lettuce;

import cn.sliew.milky.cache.AbstractCacheFactory;
import cn.sliew.milky.cache.Cache;
import cn.sliew.milky.cache.CacheOptions;

import static com.google.common.base.Preconditions.checkArgument;

public class LettuceCacheFactory extends AbstractCacheFactory {

    @Override
    protected Cache newCache(CacheOptions options) {
        checkArgument(options instanceof LettuceCacheOptions);
        LettuceCacheOptions lettuceOptions = (LettuceCacheOptions) options;
        return new LettuceCache(lettuceOptions);
    }

}