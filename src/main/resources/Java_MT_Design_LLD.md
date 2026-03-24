------------------------
Multithreading Concepts:
------------------------
Thread lifecycle
Thread creation
ExecutorService basics
Runnable vs Callable
Future / submit / execute
ScheduledExecutorService vs Timer
Thread pool internals and core vs max threads
BlockingQueue types
Rejection policies
Thread pool sizing (CPU vs IO, DB pool alignment)
synchronized - method vs block
Deadlock & Livelock
ReentrantLock & Condition
CompletableFuture and various methods
ThreadLocal and its reference in SpringBoot

-----------------------------
Design patterns (13 Patterns)
-----------------------------
CREATIONAL
- Singleton (with break cases: threads, reflection, serialization, clone) [Alternative: use Enum to create singleton objects]
- Factory Method
- Abstract Factory
- Builder
- Prototype

Structural:
- Adapter
- Decorator
- Proxy

Behavioral:
- Strategy
- Observer
- State
- Template Method
- Iterator

---------------
LLD Problems
---------------
1.Parking Lot
2.Log Aggregation & parsing (2 problems)
3.Rate Limiter (fixed, sliding window, bucket)
4.Log analytics (Top k endpoints)
5.LRU Cache
6.TTL Cache
7.Job Scheduler
8.Median Stream (Two heap usage)

--Expected to complete

Logger Rate Limiter
Interval Booking System
Bounded Blocking Queue
Distributed Rate Limiter
Consistent Hashing
Event Dedup + Ordering
Sliding Window Median