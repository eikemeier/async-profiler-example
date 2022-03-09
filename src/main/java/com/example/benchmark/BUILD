load("@rules_java//java:defs.bzl", "java_library", "java_plugin")

java_plugin(
    name = "jmh_processor",
    processor_class = "org.openjdk.jmh.generators.BenchmarkProcessor",
    deps = ["@maven//:org_openjdk_jmh_jmh_generator_annprocess"],
)

java_library(
    name = "benchmark_library",
    srcs = glob(["*.java"]),
    plugins = ["jmh_processor"],
    visibility = ["//visibility:public"],
    deps = ["@maven//:org_openjdk_jmh_jmh_core"],
)

java_binary(
    name = "benchmark",
    data = select({
        "//third_party/async_profiler:supports_profiling": [
            "//third_party/async_profiler:async_profiler",
            "//third_party/async_profiler:async_profiler_ext",
        ],
        "//conditions:default": [],
    }),
    jvm_flags = select({
        "//third_party/async_profiler:supports_profiling": [
            "-Djava.library.path=$$(dirname $(rootpath //third_party/async_profiler:async_profiler))",
        ],
        "//conditions:default": [],
    }),
    main_class = "org.openjdk.jmh.Main",
    visibility = ["//visibility:public"],
    runtime_deps = [":benchmark_library"],
)

java_binary(
    name = "benchmark26",
    data = select({
        "//third_party/async_profiler:supports_profiling": [
            "//third_party/async_profiler:async_profiler26",
            "//third_party/async_profiler:async_profiler26_ext",
        ],
        "//conditions:default": [],
    }),
    jvm_flags = select({
        "//third_party/async_profiler:supports_profiling": [
            "-Djava.library.path=$$(dirname $(rootpath //third_party/async_profiler:async_profiler26))",
        ],
        "//conditions:default": [],
    }),
    main_class = "org.openjdk.jmh.Main",
    visibility = ["//visibility:public"],
    runtime_deps = [":benchmark_library"],
)
