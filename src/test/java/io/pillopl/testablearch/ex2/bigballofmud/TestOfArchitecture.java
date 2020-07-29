package io.pillopl.testablearch.ex2.bigballofmud;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "io.pillopl.testablearch.ex2")
class TestOfArchitecture {


    @ArchTest
    public static ArchRule layers = layeredArchitecture()
            .layer("oldmodel").definedBy("io.pillopl.testablearch.ex2.bigballofmud..")
            .layer("newmodel").definedBy("io.pillopl.testablearch.ex2.newmodel..")
            .layer("acl").definedBy("io.pillopl.testablearch.ex2.acl..")
            .whereLayer("oldmodel").mayOnlyBeAccessedByLayers("acl");


}