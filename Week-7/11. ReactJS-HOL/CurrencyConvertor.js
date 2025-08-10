import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: "",
      euro: ""
    };
  }

  handleChange = (e) => {
    this.setState({ rupees: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const euroValue = parseFloat(this.state.rupees) * 80;
    this.setState({ euro: euroValue });
    alert("Converting to Euro Amount is " + euroValue);
  };

  render() {
    return (
      <div>
        <h1 style={{ color: "green" }}>Currency Convertor!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <label>Amount:</label><br />
          <input
            type="number"
            value={this.state.rupees}
            onChange={this.handleChange}
          /><br /><br />
          <label>Currency:</label><br />
          <input type="text" value="Euro" readOnly /><br /><br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
