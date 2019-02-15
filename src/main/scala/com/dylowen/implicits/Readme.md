# Implicit Evidence

[Scala Source](ImplicitEvidence.scala)

```java
package com.dylowen.implicits;

import scala.collection.Seq;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;

@ScalaSignature(
   bytes = "\u0006\u0001\u0019<Q!\u0001\u0002\t\u0002%\t\u0001#S7qY&\u001c\u0017\u000e^#wS\u0012,gnY3\u000b\u0005\r!\u0011!C5na2L7-\u001b;t\u0015\t)a!A\u0004es2|w/\u001a8\u000b\u0003\u001d\t1aY8n\u0007\u0001\u0001\"AC\u0006\u000e\u0003\t1Q\u0001\u0004\u0002\t\u00025\u0011\u0001#S7qY&\u001c\u0017\u000e^#wS\u0012,gnY3\u0014\u0005-q\u0001CA\b\u0013\u001b\u0005\u0001\"\"A\t\u0002\u000bM\u001c\u0017\r\\1\n\u0005M\u0001\"AB!osJ+g\rC\u0003\u0016\u0017\u0011\u0005a#\u0001\u0004=S:LGO\u0010\u000b\u0002\u0013!)\u0001d\u0003C\u00013\u0005!Q.Y5o)\tQR\u0004\u0005\u0002\u00107%\u0011A\u0004\u0005\u0002\u0005+:LG\u000fC\u0003\u001f/\u0001\u0007q$\u0001\u0003be\u001e\u001c\bcA\b!E%\u0011\u0011\u0005\u0005\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0003G)r!\u0001\n\u0015\u0011\u0005\u0015\u0002R\"\u0001\u0014\u000b\u0005\u001dB\u0011A\u0002\u001fs_>$h(\u0003\u0002*!\u00051\u0001K]3eK\u001aL!a\u000b\u0017\u0003\rM#(/\u001b8h\u0015\tI\u0003\u0003C\u0003/\u0017\u0011\u0005q&A\u0003qe&tG/\u0006\u00021yQ\u0011\u0011'\u0012\u000b\u00035IBqaM\u0017\u0002\u0002\u0003\u000fA'\u0001\u0006fm&$WM\\2fIE\u00022!\u000e\u001d;\u001b\u00051$BA\u001c\u0011\u0003\u001d\u0011XM\u001a7fGRL!!\u000f\u001c\u0003\u0011\rc\u0017m]:UC\u001e\u0004\"a\u000f\u001f\r\u0001\u0011)Q(\fb\u0001}\t\tA+\u0005\u0002@\u0005B\u0011q\u0002Q\u0005\u0003\u0003B\u0011qAT8uQ&tw\r\u0005\u0002\u0010\u0007&\u0011A\t\u0005\u0002\u0004\u0003:L\b\"\u0002$.\u0001\u00049\u0015A\u0002;iS:<7\u000fE\u0002I\u001b\ns!!S&\u000f\u0005\u0015R\u0015\"A\t\n\u00051\u0003\u0012a\u00029bG.\fw-Z\u0005\u0003\u001d>\u00131aU3r\u0015\ta\u0005\u0003C\u0003R\u0017\u0011\u0005!+A\u0006qe&tG\u000fT3wK2\fTCA*Z)\t!&\f\u0006\u0002\u001b+\")a\u000b\u0015a\u0002/\u0006\u0011QM\u001e\t\u0004kaB\u0006CA\u001eZ\t\u0015i\u0004K1\u0001?\u0011\u00151\u0005\u000b1\u0001H\u0011\u0015a6\u0002\"\u0001^\u0003-\u0001(/\u001b8u\u0019\u00164X\r\u001c\u001a\u0016\u0005y#GCA0f)\tQ\u0002\rC\u0003b7\u0002\u000f!-\u0001\u0005fm&$WM\\2f!\r)\u0004h\u0019\t\u0003w\u0011$Q!P.C\u0002yBQAR.A\u0002\u001d\u0003"
)
public final class ImplicitEvidence {
   public static <T> void printLevel2(final Seq<Object> things, final ClassTag<T> evidence) {
      ImplicitEvidence$.MODULE$.printLevel2(var0, var1);
   }

   public static <T> void printLevel1(final Seq<Object> things, final ClassTag<T> ev) {
      ImplicitEvidence$.MODULE$.printLevel1(var0, var1);
   }

   public static <T> void print(final Seq<Object> things, final ClassTag<T> evidence$1) {
      ImplicitEvidence$.MODULE$.print(var0, var1);
   }

   public static void main(final String[] args) {
      ImplicitEvidence$.MODULE$.main(var0);
   }
}
```

```java
package com.dylowen.implicits;

import java.lang.invoke.SerializedLambda;
import scala.Function1;
import scala.Option;
import scala.collection.Seq;
import scala.collection.Seq.;
import scala.reflect.ClassTag;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

public final class ImplicitEvidence$ {
   public static ImplicitEvidence$ MODULE$;

   static {
      new ImplicitEvidence$();
   }

   public void main(final String[] args) {
      Seq things = (Seq).MODULE$.apply(scala.Predef..MODULE$.genericWrapArray(new Object[]{"test", BoxesRunTime.boxToInteger(1), "test2", BoxesRunTime.boxToInteger(2), "test3"}));
      this.print(things, scala.reflect.ClassTag..MODULE$.Int());
      this.printLevel1(things, scala.reflect.ClassTag..MODULE$.Int());
      this.printLevel2(things, scala.reflect.ClassTag..MODULE$.Int());
   }

   public <T> void print(final Seq<Object> things, final ClassTag<T> evidence$1) {
      things.foreach((x0$1) -> {
         $anonfun$print$1(evidence$1, x0$1);
         return BoxedUnit.UNIT;
      });
   }

   public <T> void printLevel1(final Seq<Object> things, final ClassTag<T> evidence) {
      things.foreach((x0$2) -> {
         $anonfun$printLevel1$1(evidence, x0$2);
         return BoxedUnit.UNIT;
      });
   }

   public <T> void printLevel2(final Seq<Object> things, final ClassTag<T> evidence) {
      things.foreach((x0$3) -> {
         $anonfun$printLevel2$1(evidence, x0$3);
         return BoxedUnit.UNIT;
      });
   }

   // $FF: synthetic method
   public static final void $anonfun$print$1(final ClassTag evidence$1$1, final Object x0$1) {
      Option var4 = evidence$1$1.unapply(x0$1);
      BoxedUnit var2;
      if (!var4.isEmpty() && var4.get() instanceof Object) {
         scala.Predef..MODULE$.println(x0$1);
         var2 = BoxedUnit.UNIT;
      } else {
         var2 = BoxedUnit.UNIT;
      }

   }

   // $FF: synthetic method
   public static final void $anonfun$printLevel1$1(final ClassTag evidence$2, final Object x0$2) {
      Option var4 = evidence$2.unapply(x0$2);
      BoxedUnit var2;
      if (!var4.isEmpty() && var4.get() instanceof Object) {
         scala.Predef..MODULE$.println(x0$2);
         var2 = BoxedUnit.UNIT;
      } else {
         var2 = BoxedUnit.UNIT;
      }

   }

   // $FF: synthetic method
   public static final void $anonfun$printLevel2$1(final ClassTag evidence$3, final Object x0$3) {
      Option var4 = evidence$3.unapply(x0$3);
      BoxedUnit var2;
      if (!var4.isEmpty()) {
         Object var5 = var4.get();
         Option var6 = evidence$3.unapply(var5);
         if (!var6.isEmpty() && var6.get() instanceof Object) {
            scala.Predef..MODULE$.println(x0$3);
            var2 = BoxedUnit.UNIT;
            return;
         }
      }

      var2 = BoxedUnit.UNIT;
   }

   private ImplicitEvidence$() {
      MODULE$ = this;
   }

   // $FF: synthetic method
   private static Object $deserializeLambda$(SerializedLambda var0) {
      return Class.lambdaDeserialize<invokedynamic>(var0);
   }
}
```

Looking at the decompiled source you can see that even though we don't use `evidence` in our code the compiler is using it to
actually provide a reflected class of the generic. Once we have an implementation of the ClassTag we can use the unapply method
on it to check the runtime type

```scala
  def unapply(x: Any): Option[T] =
    if (null != x && (
            (runtimeClass.isInstance(x))
         || (x.isInstanceOf[Byte]    && runtimeClass.isAssignableFrom(classOf[Byte]))
         || (x.isInstanceOf[Short]   && runtimeClass.isAssignableFrom(classOf[Short]))
         || (x.isInstanceOf[Char]    && runtimeClass.isAssignableFrom(classOf[Char]))
         || (x.isInstanceOf[Int]     && runtimeClass.isAssignableFrom(classOf[Int]))
         || (x.isInstanceOf[Long]    && runtimeClass.isAssignableFrom(classOf[Long]))
         || (x.isInstanceOf[Float]   && runtimeClass.isAssignableFrom(classOf[Float]))
         || (x.isInstanceOf[Double]  && runtimeClass.isAssignableFrom(classOf[Double]))
         || (x.isInstanceOf[Boolean] && runtimeClass.isAssignableFrom(classOf[Boolean]))
         || (x.isInstanceOf[Unit]    && runtimeClass.isAssignableFrom(classOf[Unit])))
       ) Some(x.asInstanceOf[T])
    else None
```

