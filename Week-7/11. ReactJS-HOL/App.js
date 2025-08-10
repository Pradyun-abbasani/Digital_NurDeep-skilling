import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 1
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    alert("Hello! This is a static message.");
  };

  handleIncrement = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  handleClick = () => {
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1>{this.state.count}</h1>
        <button onClick={this.handleIncrement}>Increment</button><br /><br />
        <button onClick={this.decrement}>Decrement</button><br /><br />
        <button onClick={() => this.sayWelcome("Welcome")}>Say welcome</button><br /><br />
        <button onClick={this.handleClick}>Click on me</button><br /><br />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
