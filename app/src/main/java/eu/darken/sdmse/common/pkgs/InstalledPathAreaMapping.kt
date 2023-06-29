package eu.darken.sdmse.common.pkgs

import eu.darken.sdmse.common.areas.DataArea
import eu.darken.sdmse.common.files.APath
import eu.darken.sdmse.common.pkgs.features.Installed
import eu.darken.sdmse.common.user.UserHandle2

suspend fun Installed.getPrivateDataDirs(areas: Collection<DataArea>, userHandle: UserHandle2): Collection<APath> {
    val privateAreas = areas
        .filter { it.type == DataArea.Type.PRIVATE_DATA }
        .filter { it.userHandle == userHandle }

    if (privateAreas.isEmpty()) throw IllegalArgumentException("No PRIVATE_DATA areas provided")

    return privateAreas.map { it.path.child(packageName) }
}