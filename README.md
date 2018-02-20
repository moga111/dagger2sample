**Minimal MVP Android Dagger App** 

`dagger` package contains:

    |-- components
        |-- ApplicationComponent.java
        |-- subcomponents
            |-- MainActivityComponent.java
    |-- modules
        |-- ActivityBuilder.java
        |-- ApplicationModule.java
        |-- MainActivityModule.java
        
`presenter` package contains:

    |-- MainPresenter.java

`ui` package contains:

    |-- MainActivity.java
    |-- MainView.java
    
The root contains the `MainApplication`

Dagger 2.10 introduced a new way for Android DI.
Injecting fragments/activities are much easier now, all we need is to create `ApplicationComponent` that defines modules including a module the represents our activities/fragments

This example uses the new way in its simplest form possible.
The `MainActivity` is injected, its `MainPresenter` is also injected and a function is called `onCreate`
and lets not forget that the `MainApplication` is injected as well.

To add a new activity:



* Create a presenter
* Create view interface
* Create an activity
* Make the activity implement the view interface
* Inside the new activity, @inject the presenter
* Inside the new presenter, @inject the view
* Now that you did the obvious part, its time to work inside Dagger package


* inside `subcomponents`, create a new Component prefixed with activity name
 example: `SecondActivityComponent` and paste inside:

        @Subcomponent(modules = SecondActivityModule.class)
        public interface SecondActivityComponent extends AndroidInjector<SecondActivity> {
            @Subcomponent.Builder
            abstract class Builder extends AndroidInjector.Builder<SecondActivity>{}
        }
        
* update `ActivityBuilder` to include the new activity
* Last step, create a module inside the `modules` package named for example `SecondActivityModule`
        inside paste this:

        @Module
        public class SecondActivityModule {
            @Provides
            SecondView provideSecondView(SecondActivity secondActivity) {
                return secondActivity;
            }
        
            @Provides
            SecondPresenter provideSecondPresenter(SecondView secondView) {
                return new SecondPresenter(secondView);
            }
        }

This is just a helpful bootstrap for dagger 2.10+ application.

The intention is to keep it as a reference, and help new dagger users to jump start.

