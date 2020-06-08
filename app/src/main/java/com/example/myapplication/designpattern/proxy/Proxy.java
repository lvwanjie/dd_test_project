
package com.example.myapplication.designpattern.proxy;


import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;


import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;



@RequiresApi(api = Build.VERSION_CODES.N)
public class Proxy implements java.io.Serializable {

    private static final long serialVersionUID = -2222568056686623797L;

    /** parameter types of a proxy class constructor */
    private static final Class<?>[] constructorParams =
            { InvocationHandler.class };


    private static final WeakCache<ClassLoader, Class<?>[], Class<?>>
            proxyClassCache ;

    static {
        Object object = null;
        try {
            Class clzOut = Class.forName("java.lang.reflect.Proxy");
            Constructor outCc = clzOut.getDeclaredConstructor();
            outCc.setAccessible(true);
            Object out = outCc.newInstance();

            Class clz = Class.forName("java.lang.reflect.Proxy$ProxyClassFactory");
            Constructor cc =clz.getDeclaredConstructor();
            cc.setAccessible(true);
            object = cc.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        proxyClassCache = new WeakCache<>(new KeyFactory(), (BiFunction<ClassLoader, Class<?>[], Class<?>>) object);
//        proxyClassCache = new WeakCache<>(new KeyFactory(), new ProxyClassFactory());

    }

    /**
     * the invocation handler for this proxy instance.
     * @serial
     */
    protected InvocationHandler h;

    /**
     * Prohibits instantiation.
     */
    private Proxy() {
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    protected Proxy(InvocationHandler h) {
        Objects.requireNonNull(h);
        this.h = h;
    }



    public static Class<?> getProxyClass(ClassLoader loader,
                                         Class<?>... interfaces)
            throws IllegalArgumentException
    {
        // BEGIN Android-changed: Excluded SecurityManager / permission checks.
        /*
        final Class<?>[] intfs = interfaces.clone();
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            checkProxyAccess(Reflection.getCallerClass(), loader, intfs);
        }

        return getProxyClass0(loader, intfs);
        */

        return getProxyClass0(loader, interfaces);
        // END Android-changed: Excluded SecurityManager / permission checks.
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private static Class<?> getProxyClass0(ClassLoader loader,
                                           Class<?>... interfaces) {
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }

        // If the proxy class defined by the given loader implementing
        // the given interfaces exists, this will simply return the cached copy;
        // otherwise, it will create the proxy class via the ProxyClassFactory
        return proxyClassCache.get(loader, interfaces);
    }


    private static final Object key0 = new Object();

    private static final class Key1 extends WeakReference<Class<?>> {
        private final int hash;

        Key1(Class<?> intf) {
            super(intf);
            this.hash = intf.hashCode();
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            Class<?> intf;
            return this == obj ||
                    obj != null &&
                            obj.getClass() == Key1.class &&
                            (intf = get()) != null &&
                            intf == ((Key1) obj).get();
        }
    }

    /*
     * a key used for proxy class with 2 implemented interfaces
     */
    private static final class Key2 extends WeakReference<Class<?>> {
        private final int hash;
        private final WeakReference<Class<?>> ref2;

        Key2(Class<?> intf1, Class<?> intf2) {
            super(intf1);
            hash = 31 * intf1.hashCode() + intf2.hashCode();
            ref2 = new WeakReference<Class<?>>(intf2);
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            Class<?> intf1, intf2;
            return this == obj ||
                    obj != null &&
                            obj.getClass() == Key2.class &&
                            (intf1 = get()) != null &&
                            intf1 == ((Key2) obj).get() &&
                            (intf2 = ref2.get()) != null &&
                            intf2 == ((Key2) obj).ref2.get();
        }
    }

    /*
     * a key used for proxy class with any number of implemented interfaces
     * (used here for 3 or more only)
     */
    private static final class KeyX {
        private final int hash;
        private final WeakReference<Class<?>>[] refs;

        @SuppressWarnings("unchecked")
        KeyX(Class<?>[] interfaces) {
            hash = Arrays.hashCode(interfaces);
            refs = (WeakReference<Class<?>>[])new WeakReference<?>[interfaces.length];
            for (int i = 0; i < interfaces.length; i++) {
                refs[i] = new WeakReference<Class<?>>(interfaces[i]);
            }
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj ||
                    obj != null &&
                            obj.getClass() == KeyX.class &&
                            equals(refs, ((KeyX) obj).refs);
        }

        private static boolean equals(WeakReference<Class<?>>[] refs1,
                                      WeakReference<Class<?>>[] refs2) {
            if (refs1.length != refs2.length) {
                return false;
            }
            for (int i = 0; i < refs1.length; i++) {
                Class<?> intf = refs1[i].get();
                if (intf == null || intf != refs2[i].get()) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * A function that maps an array of interfaces to an optimal key where
     * Class objects representing interfaces are weakly referenced.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static final class KeyFactory
            implements BiFunction<ClassLoader, Class<?>[], Object>
    {
        @Override
        public Object apply(ClassLoader classLoader, Class<?>[] interfaces) {
            switch (interfaces.length) {
                case 1: return new Key1(interfaces[0]); // the most frequent
                case 2: return new Key2(interfaces[0], interfaces[1]);
                case 0: return key0;
                default: return new KeyX(interfaces);
            }
        }
    }

    // BEGIN Android-changed: How proxies are generated.
    /**
     * Orders methods by their name, parameters, return type and inheritance relationship.
     *
     * @hide
     */
    private static final Comparator<Method> ORDER_BY_SIGNATURE_AND_SUBTYPE = new Comparator<Method>() {
        @Override public int compare(Method a, Method b) {

            int comparison = ORDER_BY_SIGNATURE.compare(a, b);
            if (comparison != 0) {
                return comparison;
            }
            Class<?> aClass = a.getDeclaringClass();
            Class<?> bClass = b.getDeclaringClass();
            if (aClass == bClass) {
                return 0;
            } else if (aClass.isAssignableFrom(bClass)) {
                return 1;
            } else if (bClass.isAssignableFrom(aClass)) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    /**
     * A factory function that generates, defines and returns the proxy class given
     * the ClassLoader and array of interfaces.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static final class ProxyClassFactory
            implements BiFunction<ClassLoader, Class<?>[], Class<?>>
    {
        // prefix for all proxy class names
        private static final String proxyClassNamePrefix = "$Proxy";

        // next number to use for generation of unique proxy class names
        private static final AtomicLong nextUniqueNumber = new AtomicLong();

        @Override
        public Class<?> apply(ClassLoader loader, Class<?>[] interfaces) {

            Map<Class<?>, Boolean> interfaceSet = new IdentityHashMap<>(interfaces.length);
            for (Class<?> intf : interfaces) {
                /*
                 * Verify that the class loader resolves the name of this
                 * interface to the same Class object.
                 */
                Class<?> interfaceClass = null;
                try {
                    interfaceClass = Class.forName(intf.getName(), false, loader);
                } catch (ClassNotFoundException e) {
                }
                if (interfaceClass != intf) {
                    throw new IllegalArgumentException(
                            intf + " is not visible from class loader");
                }
                /*
                 * Verify that the Class object actually represents an
                 * interface.
                 */
                if (!interfaceClass.isInterface()) {
                    throw new IllegalArgumentException(
                            interfaceClass.getName() + " is not an interface");
                }
                /*
                 * Verify that this interface is not a duplicate.
                 */
                if (interfaceSet.put(interfaceClass, Boolean.TRUE) != null) {
                    throw new IllegalArgumentException(
                            "repeated interface: " + interfaceClass.getName());
                }
            }

            String proxyPkg = null;     // package to define proxy class in
            int accessFlags = Modifier.PUBLIC | Modifier.FINAL;

            /*
             * Record the package of a non-public proxy interface so that the
             * proxy class will be defined in the same package.  Verify that
             * all non-public proxy interfaces are in the same package.
             */
            for (Class<?> intf : interfaces) {
                int flags = intf.getModifiers();
                if (!Modifier.isPublic(flags)) {
                    accessFlags = Modifier.FINAL;
                    String name = intf.getName();
                    int n = name.lastIndexOf('.');
                    String pkg = ((n == -1) ? "" : name.substring(0, n + 1));
                    if (proxyPkg == null) {
                        proxyPkg = pkg;
                    } else if (!pkg.equals(proxyPkg)) {
                        throw new IllegalArgumentException(
                                "non-public interfaces from different packages");
                    }
                }
            }

            if (proxyPkg == null) {
                // if no non-public proxy interfaces, use the default package.
                proxyPkg = "";
            }

            {
                // Android-changed: Generate the proxy directly instead of calling
                // through to ProxyGenerator.
                List<Method> methods = getMethods(interfaces);
                Collections.sort(methods, ORDER_BY_SIGNATURE_AND_SUBTYPE);
                validateReturnTypes(methods);
                List<Class<?>[]> exceptions = deduplicateAndGetExceptions(methods);

                Method[] methodsArray = methods.toArray(new Method[methods.size()]);
                Class<?>[][] exceptionsArray = exceptions.toArray(new Class<?>[exceptions.size()][]);

                /*
                 * Choose a name for the proxy class to generate.
                 */
                long num = nextUniqueNumber.getAndIncrement();
                String proxyName = proxyPkg + proxyClassNamePrefix + num;

                return generateProxy(proxyName, interfaces, loader, methodsArray,
                        exceptionsArray);
            }
        }
    }


    public static List<Class<?>[]> deduplicateAndGetExceptions(List<Method> methods) {
        List<Class<?>[]> exceptions = new ArrayList<Class<?>[]>(methods.size());

        for (int i = 0; i < methods.size(); ) {
            Method method = methods.get(i);
            Class<?>[] exceptionTypes = method.getExceptionTypes();

            if (i > 0 && ORDER_BY_SIGNATURE.compare(method, methods.get(i - 1)) == 0) {
                exceptions.set(i - 1, intersectExceptions(exceptions.get(i - 1), exceptionTypes));
                methods.remove(i);
            } else {
                exceptions.add(exceptionTypes);
                i++;
            }
        }
        return exceptions;
    }

    /**
     * Returns the exceptions that are declared in both {@code aExceptions} and
     * {@code bExceptions}. If an exception type in one array is a subtype of an
     * exception from the other, the subtype is included in the intersection.
     */
    private static Class<?>[] intersectExceptions(Class<?>[] aExceptions, Class<?>[] bExceptions) {
        if (aExceptions.length == 0 || bExceptions.length == 0) {
            return null;
        }
        if (Arrays.equals(aExceptions, bExceptions)) {
            return aExceptions;
        }
        Set<Class<?>> intersection = new HashSet<Class<?>>();
        for (Class<?> a : aExceptions) {
            for (Class<?> b : bExceptions) {
                if (a.isAssignableFrom(b)) {
                    intersection.add(b);
                } else if (b.isAssignableFrom(a)) {
                    intersection.add(a);
                }
            }
        }
        return intersection.toArray(new Class<?>[intersection.size()]);
    }

    /**
     * Throws if any two methods in {@code methods} have the same name and
     * parameters but incompatible return types.
     *
     * @param methods the methods to find exceptions for, ordered by name and
     *     signature.
     */
    private static void validateReturnTypes(List<Method> methods) {
        Method vs = null;
            for (Method method : methods) {

            if (vs == null ||!((vs.getName()+"").equals(method.getName()))) {
                vs = method; // this has a different name or parameters
                continue;
            }
            Class<?> returnType = method.getReturnType();
            Class<?> vsReturnType = vs.getReturnType();
            if (returnType.isInterface() && vsReturnType.isInterface()) {
                // all interfaces are mutually compatible
            } else if (vsReturnType.isAssignableFrom(returnType)) {
                vs = method; // the new return type is a subtype; use it instead
            } else if (!returnType.isAssignableFrom(vsReturnType)) {
                throw new IllegalArgumentException("proxied interface methods have incompatible "
                        + "return types:\n  " + vs + "\n  " + method);
            }
        }
    }

    private static List<Method> getMethods(Class<?>[] interfaces) {
        List<Method> result = new ArrayList<Method>();
        try {
            result.add(Object.class.getMethod("equals", Object.class));
            result.add(Object.class.getMethod("hashCode"));
            result.add(Object.class.getMethod("toString"));
        } catch (NoSuchMethodException e) {
            throw new AssertionError();
        }

        getMethodsRecursive(interfaces, result);
        return result;
    }

    /**
     * Fills {@code proxiedMethods} with the methods of {@code interfaces} and
     * the interfaces they extend. May contain duplicates.
     */
    private static void getMethodsRecursive(Class<?>[] interfaces, List<Method> methods) {
        for (Class<?> i : interfaces) {
            getMethodsRecursive(i.getInterfaces(), methods);
            Collections.addAll(methods, i.getDeclaredMethods());
        }
    }


    private static native Class<?> generateProxy(String name, Class<?>[] interfaces,
                                                 ClassLoader loader, Method[] methods,
                                                 Class<?>[][] exceptions);



    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
            throws IllegalArgumentException
    {
        Objects.requireNonNull(h);

        final Class<?>[] intfs = interfaces.clone();

        Class<?> cl = getProxyClass0(loader, intfs);


        try {

            final Constructor<?> cons = cl.getConstructor(constructorParams);
            final InvocationHandler ih = h;
            if (!Modifier.isPublic(cl.getModifiers())) {


                cons.setAccessible(true);
                // END Android-removed: Excluded AccessController.doPrivileged call.
            }
            return cons.newInstance(new Object[]{h});
        } catch (IllegalAccessException|InstantiationException e) {
            throw new InternalError(e.toString(), e);
        } catch (InvocationTargetException e) {
            Throwable t = e.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new InternalError(t.toString(), t);
            }
        } catch (NoSuchMethodException e) {
            throw new InternalError(e.toString(), e);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean isProxyClass(Class<?> cl) {
        return Proxy.class.isAssignableFrom(cl) && proxyClassCache.containsValue(cl);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static InvocationHandler getInvocationHandler(Object proxy)
            throws IllegalArgumentException
    {
        if (!isProxyClass(proxy.getClass())) {
            throw new IllegalArgumentException("not a proxy instance");
        }

        final Proxy p = (Proxy) proxy;
        final InvocationHandler ih = p.h;

        return ih;
    }

    private static Object invoke(Proxy proxy, Method method, Object[] args) throws Throwable {
        InvocationHandler h = proxy.h;
        return h.invoke(proxy, method, args);
    }


    public static Comparator getORDER_BY_SIGNATURE(){
        Comparator<Method> comparator = null;
        try {
            Class<?> methodClz = Class.forName("java.lang.reflect.Method");
            Field[] fields = methodClz.getDeclaredFields();
            Field field = methodClz.getDeclaredField("ORDER_BY_SIGNATURE");
            comparator= (Comparator<Method>) field.get(Method.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return comparator;
    }


    public static boolean invokeEqualsMethod(Method method1,Method method2){
        boolean b = false;
        try {
           Method method =  Method.class.getDeclaredMethod("equalNameAndParameters",Method.class);
            b = (boolean) method.invoke(method1,method2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return b;
    }


    public static final Comparator<Method> ORDER_BY_SIGNATURE = new Comparator<Method>() {
        @Override public int compare(Method a, Method b) {
            if (a == b) {
                return 0;
            }
            int comparison = a.getName().compareTo(b.getName());
            if (comparison == 0) {
//                comparison = a.compareMethodParametersInternal(b);
//                if (comparison == 0) {
//                    // This is necessary for methods that have covariant return types.
//                    Class<?> aReturnType = a.getReturnType();
//                    Class<?> bReturnType = b.getReturnType();
//                    if (aReturnType == bReturnType) {
//                        comparison = 0;
//                    } else {
//                        comparison = aReturnType.getName().compareTo(bReturnType.getName());
//                    }
//                }
            }
            return comparison;
        }
    };

}
