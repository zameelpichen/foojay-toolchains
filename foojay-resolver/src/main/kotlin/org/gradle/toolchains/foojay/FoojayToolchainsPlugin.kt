/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.gradle.toolchains.foojay

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.api.internal.SettingsInternal
import org.gradle.jvm.toolchain.JavaToolchainResolverRegistry
import org.gradle.util.GradleVersion

@Suppress("unused")
abstract class FoojayToolchainsPlugin: Plugin<Settings> {

    override fun apply(settings: Settings) {
        if (GradleVersion.current().baseVersion < GradleVersion.version("7.6")) {
            throw RuntimeException("${FoojayToolchainsPlugin::class.simpleName} needs Gradle version 7.6 or higher")
        }

        settings.plugins.apply("jvm-toolchain-management")

        val registry = (settings as SettingsInternal).services.get(JavaToolchainResolverRegistry::class.java)
        registry.register(FoojayToolchainResolver::class.java)
    }

}
