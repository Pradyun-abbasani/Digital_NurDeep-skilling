import React from 'react';

class Cart extends React.Component {
  render() {
    return (
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Item Name</th>
            <th>Price (₹)</th>
          </tr>
        </thead>
        <tbody>
          {this.props.item.map((itemObj, index) => (
            <tr key={index}>
              <td>{itemObj.itemname}</td>
              <td>{itemObj.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}

export default Cart;
