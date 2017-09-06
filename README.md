# Android Router

## Installation

## Concepts

## How to use

We implemented base router and 2 satellites out of the box. 
There are activities and fragments satellites and several following commands.

First of all, you need to attach **satellite** to **router**.

```java
    private Router router = new BaseRouter();
    private Satellite satellite = new ActivitySatellite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        router.attachSatellite(satellite);
    }
```

### Available activity commands
- Start
- StartForResult
- Finish
- With
- And _(Sugar)_

```java
router.pushCommand(new Start(SecondaryActivity.class));
```

```java
router.pushCommand(new FinishThis(new And(new Start(SecondaryActivity.class))));
```

```java
Bundle args = new Bundle();
args.putInt("args", 1);
router.pushCommand(new Start(SecondaryActivity.class, new With(args)));
```


### Available fragments commands
- AddToBackStack
- And _(Sugar)_
- Replace

```java
router.pushCommand(
            new Replace(new FirstFragment(), "tag", new And(new AddToBackStack(null)))
    );
```

_Note: You can find all usage examples in app folder._

## Extension

You can extend your own routing system by one of three ways.
The first way is to add new command to existing commands group.

### Add command
To add command you need to inherit new one from command group.

_Example:_
```java
    public final class Start extends ActivityCommand
    public class Replace extends FragmentCommand
```

If you need more complex functionality to manipulate command stack 
you can create your own __satellite__

### Add satellite
To add satellite you need to implement satellite interface

```java
public final class ActivitySatellite implements Satellite
```

Satellite interface

```java
public interface Satellite {
    void execute(@NonNull Command command);
}
```

And the last one opportunity to add misc functions to **router** is to write your own custom router.
 
### Add router

 To add router you need to implement router interface
 
```java
public class BaseRouter implements Router
```
 
 Router interface
 
```java
public interface Router {
    void pushCommand(@NonNull Command command);
    void attachSatellite(@NonNull Satellite satellite);
}
```

## License

MIT License

Copyright (c) 2017 Alexander Dadukin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
