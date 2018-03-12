package com.github;

import javax.lang.model.type.NullType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * PyBuiltin 最重要的类，所有模仿python内置函数都封装在此
 */
@SuppressWarnings("unchecked, unused")
public class PyBuiltin {


    private void test() {
        Integer i = null;
        Long l = null;
        Byte b = null;
        Short s = null;
        BigInteger bi = null;
        BigDecimal bd = null;
        Map m = null;
        Collection c = null;

    }

    private PyBuiltin() {
        // Singleton
    }

    // abs start
    public static Integer abs(Integer n) {
        return Math.abs(n);
    }

    public static Long abs(Long n) {
        return Math.abs(n);
    }

    public static Double abs(Double n) {
        return Math.abs(n);
    }

    public static Float abs(Float n) {
        return Math.abs(n);
    }

    public static Short abs(Short n) {
        return Short.valueOf(String.valueOf(Math.abs(n)));
    }

    public static Byte abs(Byte n) {
        return Byte.valueOf(String.valueOf(Math.abs(n)));
    }

    public static BigDecimal abs(BigDecimal n) {
        return n.abs();
    }

    public static BigInteger abs(BigInteger n) {
        return n.abs();
    }
    // abs end

    // print start
    public static void print(Object o) {
        print(o, "\n");
    }

    public static void print(Object o, String end) {
        System.out.print(String.valueOf(o) + end);
    }

    // print end
    // id start
    public static int id(Object o) {
        return hash(o);
    }

    // id end
    // len start
    public static int len(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        return c.size();
    }

    public static int len(Map m) {
        if (m == null) {
            throw new NullPointerException();
        }
        return m.size();
    }

    public static int len(Object[] o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return o.length;
    }

    public static int len(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        return s.length();
    }

    // len end
    // str start
    public static String str(Object o) {
        return String.valueOf(o);
    }

    // str end
    // int start
    public static int int_(Object o) {
        if (o == null) {
            throw new NullPointerException("Null can not cast to Integer!");
        }
        return Integer.valueOf(str(o));
    }

    // int end
    // bool start
    public static Boolean bool(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Boolean) {
            return bool((Boolean) o);
        }
        if (o instanceof String) {
            return bool((String) o);
        }
        if (o instanceof Collection) {
            return bool((Collection) o);
        }
        if (o instanceof Map) {
            return bool((Map) o);
        }
        return true;
    }

    public static Boolean bool(Boolean b) {
        return b == null ? false : b;
    }

    public static Boolean bool(String s) {
        return s != null && s != "";
    }

    public static Boolean bool(Collection c) {
        return c != null && !c.isEmpty();
    }

    public static Boolean bool(Map m) {
        return m != null && !m.isEmpty();
    }

    // bool end
    // hash start
    public static int hash(Object o) {
        return o == null ? 0 : o.hashCode();
    }

    // hash end
    // max start
    public static <T extends Object & Comparable<? super T>> T max(Map<T, Object> m, Comparator<T> cmp) {
        return Collections.max(m.keySet(), cmp);
    }

    public static <T extends Object & Comparable<? super T>> T max(Map<T, Object> m) {
        return Collections.max(m.keySet());
    }

    public static <T extends Object & Comparable<? super T>> T max(Collection<T> c, Comparator<T> cmp) {
        return Collections.max(c, cmp);
    }

    public static <T extends Object & Comparable<? super T>> T max(Collection<T> c) {
        return Collections.max(c);
    }

    // max end
    // min start
    public static <T extends Object & Comparable<? super T>> T min(Map<T, Object> m, Comparator<T> cmp) {
        return Collections.min(m.keySet(), cmp);
    }

    public static <T extends Object & Comparable<? super T>> T min(Map<T, Object> m) {
        return Collections.min(m.keySet());
    }

    public static <T extends Object & Comparable<? super T>> T min(Collection<T> c, Comparator<T> cmp) {
        return Collections.min(c, cmp);
    }

    public static <T extends Object & Comparable<? super T>> T min(Collection<T> c) {
        return Collections.min(c);
    }

    // min end
    // set start
    public static <E> Set<E> set(Collection<E> c) {
        return set(c, false);
    }

    public static <K, V> Set<K> set(Map<K, V> m) {
        return set(m, false);
    }

    public static <E> Set<E> set(E[] o) {
        return set(o, false);
    }

    public static Set<String> set(String s) {
        return set(s, false);
    }

    public static Set<String> set(String c, boolean needThreadSafe) {
        List<String> temp = Arrays.asList(c.split(""));
        return needThreadSafe ? new CopyOnWriteArraySet<>(temp) : new HashSet<>(temp);
    }

    public static <E> Set<E> set(Collection<E> c, boolean needThreadSafe) {
        return needThreadSafe ? new CopyOnWriteArraySet<>(c) : new HashSet<>(c);
    }

    public static <K, V> Set<K> set(Map<K, V> m, boolean needThreadSafe) {
        return needThreadSafe ? new CopyOnWriteArraySet<>(m.keySet()) : new HashSet<>(m.keySet());
    }

    public static <E> Set<E> set(E[] o, boolean needThreadSafe) {
        List<E> temp = Arrays.asList(o);
        return needThreadSafe ? new CopyOnWriteArraySet<>(temp) : new HashSet<>(temp);
    }

    // set end
    // list start
    public static <E> List<E> list(Collection<E> c) {
        return list(c, false);
    }

    public static <K, V> List<K> list(Map<K, V> m) {
        return list(m, false);
    }

    public static <E> List<E> list(E[] o) {
        return list(o, false);
    }

    public static List<String> list(String s) {
        return list(s, false);
    }

    public static List<String> list(String c, boolean needThreadSafe) {
        List<String> temp = Arrays.asList(c.split(""));
        return needThreadSafe ? new CopyOnWriteArrayList<>(temp) : new ArrayList<>(temp);
    }

    public static <E> List<E> list(Collection<E> c, boolean needThreadSafe) {
        return needThreadSafe ? new CopyOnWriteArrayList<>(c) : new ArrayList<>(c);
    }

    public static <K, V> List<K> list(Map<K, V> m, boolean needThreadSafe) {
        return needThreadSafe ? new CopyOnWriteArrayList<>(m.keySet()) : new ArrayList<>(m.keySet());
    }

    public static <E> List<E> list(E[] o, boolean needThreadSafe) {
        List<E> temp = Arrays.asList(o);
        return needThreadSafe ? new CopyOnWriteArrayList<>(temp) : new ArrayList<>(temp);
    }

    // list end
    // sum start
    public static <T extends Number> T sum(T[] arr) {
        if (arr == null) {
            throw new NullPointerException();
        }
        if (arr.length == 0) {
            return (T) new Integer(0);
        }
        return sum(Arrays.asList(arr));
    }

    public static <T extends Number> T sum(Map<T, Object> m) {
        if (m == null) {
            throw new NullPointerException();
        }
        if (m.isEmpty()) {
            return (T) new Integer(0);
        }
        return sum(m.keySet());
    }

    public static <T extends Number> T sum(Collection<T> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (c.isEmpty()) {
            return (T) new Integer(0);
        }
        T result = null;
        for (T t : c) {
            if (t instanceof Integer) {
                Integer temp;
                if (result == null) {
                    temp = 0;
                } else {
                    temp = (Integer) result;
                }
                Integer tempT = (Integer) t;
                temp += tempT;
                result = (T) temp;
            }
            if (t instanceof Long) {
                Long temp;
                if (result == null) {
                    temp = 0L;
                } else {
                    temp = (Long) result;
                }
                Long tempT = (Long) t;
                temp += tempT;
                result = (T) temp;
            }
            if (t instanceof Double) {
                Double temp;
                if (result == null) {
                    temp = 0.0D;
                } else {
                    temp = (Double) result;
                }
                Double tempT = (Double) t;
                temp += tempT;
                result = (T) temp;
            }
            if (t instanceof Float) {
                Float temp;
                if (result == null) {
                    temp = 0.0F;
                } else {
                    temp = (Float) result;
                }
                Float tempT = (Float) t;
                temp += tempT;
                result = (T) temp;
            }
            if (t instanceof BigInteger) {
                BigInteger temp;
                if (result == null) {
                    temp = new BigInteger("0");
                } else {
                    temp = (BigInteger) result;
                }
                BigInteger tempT = (BigInteger) t;
                temp = temp.add(tempT);
                result = (T) temp;
            }
            if (t instanceof BigDecimal) {
                BigDecimal temp;
                if (result == null) {
                    temp = new BigDecimal("0");
                } else {
                    temp = (BigDecimal) result;
                }
                BigDecimal tempT = (BigDecimal) t;
                temp = temp.add(tempT);
                result = (T) temp;
            }
            if (t instanceof Short) {
                Integer temp;
                if (result == null) {
                    temp = 0;
                } else {
                    temp = (Integer) result;
                }
                Short tempT = (Short) t;
                temp += tempT;
                result = (T) temp;
            }
            if (t instanceof Byte) {
                Integer temp;
                if (result == null) {
                    temp = 0;
                } else {
                    temp = (Integer) result;
                }
                Byte tempT = (Byte) t;
                temp += tempT;
                result = (T) temp;
            }
        }
        return result;
    }

    // sum end
    // type start
    public static Class type(Object o) {
        return o == null ? NullType.class : o.getClass();
    }

    // type end
    // any start
    public static Boolean any(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return bool(o);
    }

    public static Boolean any(Collection c) {
        if (!bool(c)) {
            return false;
        }
        boolean result = false;
        for (Object o : c) {
            if (bool(o)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static Boolean any(Map m) {
        if (!bool(m)) {
            return false;
        }
        return any(m.keySet());
    }

    // any end
    // all start
    public static Boolean all(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof Collection) {
            return all((Collection) o);
        }
        if (o instanceof Map) {
            return all((Map) o);
        }
        return true;
    }

    /**
     * 空集合也是返回true，见python all()
     *
     * @param c
     * @return
     */
    public static Boolean all(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (c.isEmpty()) {
            return true;
        }
        Boolean result = true;
        for (Object o : c) {
            if (!bool(o)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static Boolean all(Map m) {
        if (m == null) {
            throw new NullPointerException();
        }
        if (m.isEmpty()) {
            return true;
        }
        return all(m.keySet());
    }

    // all end
    // filter start
    public static <E> Collection<E> filter(Predicate<E> filter, Collection<E> source) {
        if (source instanceof List) {
            return filter(filter, (List<E>) source);
        }
        if (source instanceof Set) {
            return filter(filter, (Set<E>) source);
        }
        return null;
    }

    public static <E> List<E> filter(Predicate<E> filter, List<E> source) {
        return source.stream().filter(filter).collect(Collectors.toList());
    }

    public static <E> Set<E> filter(Predicate<E> filter, Set<E> source) {
        return source.stream().filter(filter).collect(Collectors.toSet());
    }

    // filter end
    // map start
    public static <E, R> Collection<R> map(Function<E, R> mapper, Collection<E> source) {
        if (source instanceof List) {
            return map(mapper, (List<E>) source);
        }
        if (source instanceof Set) {
            return map(mapper, (Set<E>) source);
        }
        return null;
    }

    public static <E, R> List<R> map(Function<E, R> mapper, List<E> source) {
        return source.stream().map(mapper).collect(Collectors.toList());
    }

    public static <E, R> Set<R> map(Function<E, R> mapper, Set<E> source) {
        return source.stream().map(mapper).collect(Collectors.toSet());
    }

    // map end
    // pow start
    public static Double pow(Number a, Number b) {
        if (a == null || b == null) {
            throw new NullPointerException("The number of square calculations can't be null!");
        }
        double ta = double_(a);
        double tb = double_(b);
        return Math.pow(ta, tb);
    }

    // pow end
    // long start
    public static Long long_(Number n) {
        if (n == null) {
            throw new NullPointerException();
        }
        return Long.valueOf(str(n));
    }

    // long end
    // double start
    public static Double double_(Number n) {
        if (n == null) {
            throw new NullPointerException();
        }
        return Double.valueOf(str(n));
    }

    // double end
    // float start
    public static Float float_(Number n) {
        if (n == null) {
            throw new NullPointerException();
        }
        return Float.valueOf(str(n));
    }

    // float end
    // hasattr start
    public static Boolean hasattr(Object o, String fieldName) {
        return hasattr(o, fieldName, false);
    }

    public static Boolean hasattr(Object o, String fieldName, boolean onlyPublic) {
        if (o == null || fieldName == null) {
            throw new NullPointerException();
        }
        return hasattr(o.getClass(), fieldName, onlyPublic);
    }

    public static Boolean hasattr(Class clazz, String fieldName) {
        return hasattr(clazz, fieldName, false);
    }

    public static Boolean hasattr(Class clazz, String fieldName, boolean onlyPublic) {
        if (clazz == null || fieldName == null) {
            throw new NullPointerException();
        }
        while (clazz != Object.class) {
            try {
                if (onlyPublic) {
                    clazz.getField(fieldName);
                } else {
                    clazz.getDeclaredField(fieldName);
                }
                return true;
            } catch (NoSuchFieldException e) {
                if (onlyPublic) {
                    return false;
                } else {
                    clazz = clazz.getSuperclass();
                }
            }
        }
        return false;
    }
    // hasattr end
    // sorted start

    /**
     * Notice: the function won't change the source list
     *
     * @param source
     * @param <E>
     * @return a new Collection after sorted
     */
    public static <E extends Comparable> List<E> sorted(List<E> source) {
        return sorted(source, true);
    }

    public static <E extends Comparable> List<E> sorted(List<E> source, boolean asc) {
        List<E> copy = new ArrayList<>(source);
        Collections.sort(copy);
        if (!asc) {
            Collections.reverse(copy);
        }
        return copy;
    }

    public static <E extends Comparable> Set<E> sorted(Set<E> source) {
        return sorted(source, true);
    }

    public static <E extends Comparable> Set<E> sorted(Set<E> source, boolean asc) {
        Set<E> copy = null;
        if (asc) {
            copy = new TreeSet<>(source);
        } else {
            copy = new TreeSet<>(Comparator.reverseOrder());
            copy.addAll(source);
        }
        return copy;
    }

    public static <K extends Comparable, V> Map<K, V> sorted(Map<K, V> source) {
        return sorted(source, true);
    }

    public static <K extends Comparable, V> Map<K, V> sorted(Map<K, V> source, boolean asc) {
        Map<K, V> copy = null;
        if (asc) {
            copy = new TreeMap<>(source);
        } else {
            copy = new TreeMap<>(Comparator.reverseOrder());
            copy.putAll(source);
        }
        return copy;
    }
    // sorted end
}

