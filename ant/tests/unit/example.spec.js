import {
  expect
} from "chai";
import {
  shallowMount,
  mount
} from "@vue/test-utils";
import Table from "../../src/components/Table.vue";
import App from "../../src/App.vue";

describe("Table.vue", () => {
  let component1;
  let component2;
  const passFiles = [{
    fileName: "grocery.txt",
    size: "777",
    processedTime: "19-08-2020 12:23:37"
  }];
  const failFiles = [{
    fileName: "grocery.txt",
    size: "777",
    processedTime: "19-08-2020 12:23:37"
  }, {
    fileName: "grocery.txt",
    size: "777",
    processedTime: "19-08-2020 12:23:37"
  }, {
    fileName: "grocery.txt",
    size: "777",
    processedTime: "19-08-2020 12:23:37"
  }, {
    fileName: "grocery.txt",
    size: "777",
    processedTime: "19-08-2020 12:23:37"
  }, ];

  beforeEach(() => {
    component1 = mount(Table, {
      props: {
        files: passFiles,
        isError: passFiles.length > 3
      }
    });
    component2 = mount(Table, {
      props: {
        files: failFiles,
        isError: failFiles.length > 3
      }
    });

  });

  it("should render Table on mount", () => {
    expect(component1.find("td").exists()).to.be.true;
  });

  it("should not show error when files <= 3", () => {
    expect(component1.find(".isError").exists()).to.be.false;
  });

  it("should show error when files > 3", () => {
    expect(component2.find(".isError").exists()).to.be.true;
  });
});