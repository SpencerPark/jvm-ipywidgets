package io.github.spencerpark.jupyter.ipywidgets.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WidgetsGson {
    private static final ThreadLocal<Gson> GSON_INSTANCE = ThreadLocal.withInitial(WidgetsGson::createInstance);

    public static Gson getThreadLocalInstance() {
        return GSON_INSTANCE.get();
    }

    public static GsonBuilder builder() {
        return new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapterFactory(InlineTypeAdapter.FACTORY);
    }

    public static Gson createInstance() {
        return builder().create();
    }
}